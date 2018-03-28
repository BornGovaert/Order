package be.map.Order;

import be.map.Customer.Customer;
import be.map.Item.Item;
import be.map.ItemGroup;

import javax.swing.text.html.HTMLDocument;
import java.time.LocalDate;
import java.util.*;

public class OrderRepository {


    private HashMap<String, Order> orders;


    //### Story 2: Order items
    //As a customer I want to order one or more items.
    //- An order contains one or more item groups
    //- An item group contains a selected item (id), an amount, and a shipping date.
    //    - The shipping date should be calculated automatically:
    //        - When we have the item in stock, the shipping date is set to the next day (of the order)
    //        - Otherwise the shipping date should be set to next week (day of order + 7 days)
    //- The total price should be calculated and shown to the customer when ordering.
    //- Question: should an order keep a reference to an item or should it make some sort of copy?
    //    - Tip: The the price of the item can change over time... What implications might this have?
    //- Obviously, we also need to keep track of who made the order (it has to be a known customer)
    //- Prioritization: Must-Have


    public Order createOrder(Order order) {
        String uniqueID = UUID.randomUUID().toString();
        orders.put(uniqueID, order);
        return order;
    }

    //### Story 5: View report of orders
    //    //As a customer I want to see a report of all my orders so I can get an overview of what I ordered and how much it cost.
    //    //- The report should contain per order:
    //    //    - The id(entifier) of the order
    //    //    - Per item group of the order
    //    //        - The name of the item
    //    //        - The ordered amount
    //    //        - The total price of the item group
    //    //    - The total price of the order
    //    //- The total price of all orders
    //    //- Prioritization: Must-Have

    public Report getReport(String uniqueId) {
        if (uniqueIdValidator(uniqueId)) {
            return new Report(getCustomerGivenUniqueOrderId(uniqueId), getOrdersOfCustomer(uniqueId), getTotalPriceOfOrdersOfCustomer(uniqueId));
        } else {
            throw new IllegalArgumentException("Can't find a customer with that id");
        }
    }

    public Customer getCustomerGivenUniqueOrderId(String uniqueId) {
        if (uniqueIdValidator(uniqueId)) {
            Customer theCustomer = new Customer("Unknown", "Customer");
            for (Order order : orders.values()) {
                if (order.getCustomer().getUniqueID().equals(uniqueId)) {
                    theCustomer = order.getCustomer();
                }
            }
            return theCustomer;
        } else {
            throw new IllegalArgumentException("No customer found for that Id");
        }
    }


    public boolean uniqueIdValidator(String uniqueId) {
        for (Order order : orders.values()) {
            if (order.getCustomer().getUniqueID().equals(uniqueId)) {
                return true;
            }
        }
        return false;
    }


    public double getTotalPriceOfOrdersOfCustomer(String uniqueId) {
        double totalPriceAllOrders = 0;
        for (Order order : getOrdersOfCustomer(uniqueId)) {
            totalPriceAllOrders = totalPriceAllOrders + order.getOrderPrice();
        }
        return totalPriceAllOrders;
    }

    public List<Order> getOrdersOfCustomer(String uniqueId) {
        ArrayList<Order> ordersOfSpecificCustomer = new ArrayList<>();
        for (Order order : orders.values()) {
            if (uniqueId.equals(order.getCustomer().getUniqueID())) {
                ordersOfSpecificCustomer.add(order);
            } else {
                throw new IllegalArgumentException("This customer hasn't got any previous orders!");
            }
        }
        return ordersOfSpecificCustomer;
    }


    //### Story 6: Reorder an existing order
    //As a customer I want to be able to reorder an existing order so I can quickly place a recurring order.
    //- Make sure this can be done by providing an order id(entifier).
    //- A customer can only reorder one of his own orders.
    //- The actual price of the item should be used, not the price the item had in the existing order.
    //- Prioritization: Must-Have
    //
    public Order reorder(String customerUniqueId, String orderUniqueIdProvided) {
        if (orders.get(orderUniqueIdProvided).getCustomer().getUniqueID().equals(customerUniqueId)) {
            Order newOrder = new Order(orders.get(orderUniqueIdProvided).getCustomer(), updatePriceInListOfItemGroups(orderUniqueIdProvided));
            String uniqueID = UUID.randomUUID().toString();
            orders.put(uniqueID, newOrder);
            return newOrder;
        } else {
            throw new IllegalArgumentException("Customer can only reorder one of his own orders! Make sure you enter customer id first and then order unique id");
        }
    }

    public List<ItemGroup> updatePriceInListOfItemGroups(String uniqueIdProvided) {
        List<ItemGroup> itemGroupsWithUpdatedPrice = new ArrayList<>();
        for (ItemGroup itemgroup : orders.get(uniqueIdProvided).getItemGroups()) {
            ItemGroup newItemGroup = new ItemGroup(itemgroup.getItem().getId(), itemgroup.getAmount());
            itemGroupsWithUpdatedPrice.add(newItemGroup);
        }
        return itemGroupsWithUpdatedPrice;
    }


    //### Story 9: Items Shipping today
    //As an admin user I want to view all orders that contain items that should be shipped today.
    //- List the item groups that should be shipped today.
    //- Give the address where they should be shipped to.
    //- Note: item groups of the same order can have a different shipping date,
    //but all items are shipped to the same address.
    //- Prioritization: Must-Have

    public HashMap<String, List<ItemGroup>> shipTodayItems() {
        this.getAllItemGroupsPairedToAdress();
        for (List<ItemGroup> listItemGroup : this.getAllItemGroupsPairedToAdress().values()) {
            this.givenListOfItemGroupWillRemoveNotEqualToShippingDate(listItemGroup);

            //What if listItemGroup is empty?
            if (listItemGroup == null) {
                this.getAllItemGroupsPairedToAdress().remove(listItemGroup);
            }


        }
        return this.getAllItemGroupsPairedToAdress();
    }

    public List<ItemGroup> givenListOfItemGroupWillRemoveNotEqualToShippingDate(List<ItemGroup> listItemGroup) {
        for (ItemGroup itemgroup : listItemGroup) {
            if (!itemgroup.getShippingDate().equals(LocalDate.now())) {
                listItemGroup.remove(itemgroup);
            }
        }
        return listItemGroup;
    }

    //public static void printMap(Map mp) {
    //    Iterator it = mp.entrySet().iterator();
    //    while (it.hasNext()) {
    //        Map.Entry pair = (Map.Entry)it.next();
    //        System.out.println(pair.getKey() + " = " + pair.getValue());
    //        it.remove(); // avoids a ConcurrentModificationException
    //    }
    //}

    public HashMap<String, List<ItemGroup>> getAllItemGroupsPairedToAdress() {
        HashMap<String, List<ItemGroup>> adressItemGroups;
        adressItemGroups = new HashMap<String, List<ItemGroup>>();
        ArrayList<ItemGroup> itemGroups = new ArrayList<>();
        for (Order order : orders.values()) {
            adressItemGroups.put(order.getCustomer().getAdress(), order.getItemGroups());
        }
        return adressItemGroups;
    }


}


