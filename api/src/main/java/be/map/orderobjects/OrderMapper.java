package be.map.orderobjects;

import be.map.Customer.Customer;
import be.map.Order.Order;

public class OrderMapper {

    public static OrderDto orderToDto(Order orderToMap) {
        return new OrderDto()
                .withCustomer(orderToMap.getCustomer())
                .withItemGroups(orderToMap.getItemGroups());
    }

    public static Order dtoToOrder(OrderDto order) {
        return new Order(order.customer, order.itemGroups);
    }



}
