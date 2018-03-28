package be.map;

import be.map.Customer.Customer;
import be.map.Order.Order;
import be.map.Order.OrderRepository;
import be.map.Order.Report;

import javax.inject.Inject;

public class OrderService {

    private OrderRepository orderRepository;

    @Inject
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

//createorder
    public Order createOrder(Order order) {
        return orderRepository.createOrder(order);
    }

//getreport

    public Report getReport(String uniqueId) {
        return orderRepository.getReport(uniqueId);
    }
    //reorder

    public Order reorder(String customerUniqueId, String orderUniqueId) {
        return orderRepository.reorder(customerUniqueId, orderUniqueId);
    }
}
