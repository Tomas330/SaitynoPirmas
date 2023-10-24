import Util.JaxbUtil;
import jakarta.xml.bind.JAXBException;
import org.example.tchatzilias.Car;
import org.example.tchatzilias.Customer;
import org.example.tchatzilias.Order;

import java.io.IOException;

import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException {

        Car car1 = new Car("AUDI A8","349 AG (257kW", "Dyzelis", "Automatas", 195500, 15300 );
        Car car2 = new Car("Mercedes-Benz CLA220","170 AG (125kW)", "Dyzelis", "Automatas", 296000, 14500 );

        Customer customer1 = new Customer("Lukas", "Uvociovas");
        Customer customer2 = new Customer("Deividas", "Vilmantauskas");

        Order order1 = new Order("2023-11-27", List.of(customer1, customer2), List.of(car1, car2));
        JaxbUtil.convertToXML(order1, "order.xml");

        System.out.println(order1);
    }
}