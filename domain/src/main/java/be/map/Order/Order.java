package be.map.Order;

import be.map.Customer.Customer;
import be.map.ItemGroup;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private Customer customer;
    private List<ItemGroup> itemGroups;
    private double orderPrice;


    public Order() {
        customer = new Customer("Unknown FirstName", "Unknown LastName");
        itemGroups = new ArrayList<>();
    }

    public Order(Customer customer, List<ItemGroup> itemGroups) {
        this.customer = customer;
        this.itemGroups = itemGroups;
        for (ItemGroup itemgroup : itemGroups) {
            this.orderPrice = this.orderPrice + itemgroup.getTotalPriceForItemGroup();
        }
    }

    public List<ItemGroup> addItemgroupToList(List<ItemGroup> itemgroup) {
        itemGroups.addAll(itemgroup);
        return itemGroups;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                ", itemGroups=" + itemGroups +
                ", orderPrice=" + orderPrice +
                '}';
    }
}

//### Story 5: View report of orders
//As a customer I want to see a report of all my orders so I can get an overview of what I ordered and how much it cost.
//- The report should contain per order:

//    - The identifier of the order
//    - Per item group of the order
//        - The name of the item
//        - The ordered amount
//        - The total price of the item group
//    - The total price of the order
//- The total price of all orders
//- Prioritization: Must-Have

////### Story 2: Order items
////        As a customer I want to order one or more items.
////        - An order contains one or more item groups
////        - The price should also be calculated and shown to the customer when ordering.
//
//
//
////        - An item group contains a selected item (id), an amount and a shipping date.
//
//
////        - The shipping date should be calculated automatically:
////        - When we have the item in stock, the shipping date is set to the next day
////        - Otherwise the shipping date should be set to next week
//
//
//
////        - Question: should an order keep a reference to an item or should it make some sort of copy?
////        - Tip: Imagine that the price of the item changes over time
////        - Prioritization: Must-Have