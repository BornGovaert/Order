package be.map.orderobjects;

import be.map.Customer.Customer;
import be.map.ItemGroup;

import java.util.List;

public class OrderDto {

    public Customer customer;
    public List<ItemGroup> itemGroups;
    public double orderPrice;

    public OrderDto withCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public OrderDto withItemGroups(List<ItemGroup> itemGroups) {
        this.itemGroups = itemGroups;
        return this;
    }

//    public OrderDto withOrderPrice(double orderPrice) {
//        this.orderPrice = orderPrice;
//        return this;
//    }



    //private Customer customer;
    //    private List<ItemGroup> itemGroups;
    //    private double orderPrice;
}
