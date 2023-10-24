import Util.HibernateUtil;
import Util.JaxbUtil;
import org.example.tchatzilias.Car;
import org.example.tchatzilias.Customer;
import org.example.tchatzilias.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateApp {
    public static void main(String[] args){

        Car car1 = new Car("BMW 525", "197 AG (145kW)", "Dyzelis", "Automatas", 317000, 5700);
        Customer customer1 = new Customer("Aurimas", "Maciunas");
        Order order1 = new Order("2023-10-24", List.of(customer1), List.of(car1));

        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(order1);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            List<Order> orders = session.createQuery("from Order", Order.class).list();
            orders.forEach(ordr -> System.out.println());

            System.out.println("---------------------------------");
            orders.forEach(ordr -> JaxbUtil.convertToXML(ordr, "order.xml"));

            //server = Server.createTcpServer().start();
            System.in.read();
        }catch (Exception e){
            if(transaction != null){
                System.out.println(e.getMessage());
                transaction.rollback();
            }
            e.printStackTrace();
        }finally{
            //server.shutdown();
        }
    }
}