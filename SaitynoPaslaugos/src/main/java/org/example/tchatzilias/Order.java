package org.example.tchatzilias;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlType;
import javax.persistence.OneToMany;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;


@XmlRootElement
@XmlType(propOrder = {"id", "date", "customers", "cars"})
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "car_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String date;

    @XmlElementWrapper(name = "customers")
    @XmlElement(name = "customer")
    @OneToMany(targetEntity = Customer.class, cascade = CascadeType.ALL)
    private List<Customer> customers;

    @XmlElementWrapper(name = "cars")
    @XmlElement(name = "car")
    @OneToMany(targetEntity = Car.class, cascade = CascadeType.ALL)
    private List<Car> cars;

    public Order(){}

    public Order(int id, String date, List<Customer> customers, List<Car> cars) {
        this.id = id;
        this.date = date;
        this.customers = customers;
        this.cars = cars;
    }

    public Order(String date, List<Customer> customers, List<Car> cars) {
        this.date = date;
        this.customers = customers;
        this.cars = cars;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Car> getCars() { return cars; }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return String.format("Order:\n\t Date = %s\n\t" +
                        "Customers: \n\t%s" +
                        "Cars:\n\t\t%s",
                this.date,
                this.customers,
                this.cars,
                constructCustomerString(),
                constructCarString());
    }

    private String constructCustomerString(){
        String resultCustomer = "";
        for(Customer customer : this.customers){
            resultCustomer += customer.toString();
        }
        return resultCustomer;
    }

    private String constructCarString(){
        String resultCar = "";
        for(Car car : this.cars) resultCar += car.toString();
        return resultCar;
    }
}
