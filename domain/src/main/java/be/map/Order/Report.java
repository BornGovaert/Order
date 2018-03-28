package be.map.Order;

import be.map.Customer.Customer;


import java.util.List;

public class Report {

private Customer customer;
private List<Order> ordersOfCustomer;
private double totalPriceAllOrders;

    public Report(Customer customer, List<Order> ordersOfCustomer, double totalPriceAllOrders) {
        this.customer = customer;
        this.ordersOfCustomer = ordersOfCustomer;
        this.totalPriceAllOrders = totalPriceAllOrders;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Order> getOrdersOfCustomer() {
        return ordersOfCustomer;
    }

    public void setOrdersOfCustomer(List<Order> ordersOfCustomer) {
        this.ordersOfCustomer = ordersOfCustomer;
    }

    public double getTotalPriceAllOrders() {
        return totalPriceAllOrders;
    }

    public void setTotalPriceAllOrders(double totalPriceAllOrders) {
        this.totalPriceAllOrders = totalPriceAllOrders;
    }
}
