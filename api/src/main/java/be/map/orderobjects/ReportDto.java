package be.map.orderobjects;

import be.map.Customer.Customer;
import be.map.Order.Order;

import java.util.List;

public class ReportDto {

    public Customer customer;
    public List<Order> ordersOfCustomer;
    public double totalPriceAllOrders;

    public ReportDto withCustomer(Customer customer){
        this.customer = customer;
        return this;
    }

    public ReportDto withOrdersOfCustomer(List<Order> ordersOfCustomer){
        this.ordersOfCustomer = ordersOfCustomer;
        return this;
    }

    public ReportDto withTotalPriceOfAllOrders(double totalPriceAllOrders){
        this.totalPriceAllOrders = totalPriceAllOrders;
        return this;
    }
}
