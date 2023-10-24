import Util.JaxbUtil;
import org.example.tchatzilias.Car;
import org.example.tchatzilias.Customer;
import org.example.tchatzilias.Order;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 1234)) {
            // Create the Order object
            Car car1 = new Car("BMW 525", "197 AG (145kW)", "Dyzelis", "Automatas", 317000, 5700);
            Customer customer1 = new Customer("Aurimas", "Maciunas");
            Order order1 = new Order("2023-10-24", List.of(customer1), List.of(car1));

            // Convert Order to XML
            String filePath = "C:\\Users\\jonas\\Desktop\\SaitynoPaslaugos\\order.xml";
            JaxbUtil.convertToXML(order1, filePath);

            // Send XML file to server
            OutputStream outputStream = socket.getOutputStream();
            FileInputStream fileInputStream = new FileInputStream(filePath);  // Use filePath instead of xmlFile
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
            fileInputStream.close();

            // Receive response from server
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String response = reader.readLine();
            System.out.println("Server Response: " + response);

            // Transform XML to POJO
            Order receivedOrder = JaxbUtil.convertToJava(new File(filePath), Order.class);
            if (receivedOrder != null) {
                System.out.println("Received Order: " + receivedOrder);
            }

            // Close the socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
