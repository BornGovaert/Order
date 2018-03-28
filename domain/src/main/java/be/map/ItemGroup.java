package be.map;

import be.map.Item.Item;
import be.map.Item.ItemRepository;

import java.time.LocalDate;

public class ItemGroup {
    private Item item;
    private int amount;
    private LocalDate shippingDate;
    private double totalPriceForItemGroup;

    //////    - Per item group of the order
    //////        - The name of the item
    //////        - The ordered amount
    //////        - The total price of the item group

    private ItemRepository itemRepository;          // Do I need to inject?


    public ItemGroup(int itemId, int amount) {
        for (Item item : itemRepository.getItems()) {
            if (item.getId() == itemId) {
                this.item = item;
            } else {
                throw new IllegalArgumentException("No item found for that id");
            }
        }
        this.amount = amount;
        if (item.getAmount() > 0) {
            this.shippingDate = LocalDate.now().plusDays(1);
        } else {
            this.shippingDate = LocalDate.now().plusWeeks(1);
        }
        this.totalPriceForItemGroup = item.getPrice() * amount;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }

    public double getTotalPriceForItemGroup() {
        return totalPriceForItemGroup;
    }

    public void setTotalPrice(double totalPriceForItemGroup) {
        this.totalPriceForItemGroup = totalPriceForItemGroup;
    }

    public ItemRepository getItemRepository() {
        return itemRepository;
    }

    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void setTotalPriceForItemGroup(double totalPriceForItemGroup) {
        this.totalPriceForItemGroup = totalPriceForItemGroup;
    }
}

////### Story 5: View report of orders
////As a customer I want to see a report of all my orders so I can get an overview of what I ordered and how much it cost.
////- The report should contain per order:
//
////    - The identifier of the order
////    - Per item group of the order
////        - The name of the item
////        - The ordered amount
////        - The total price of the item group
////    - The total price of the order
////- The total price of all orders
////- Prioritization: Must-Have


//### Story 2: Order items
//        As a customer I want to order one or more items.
//        - An order contains one or more item groups
//        - The price should also be calculated and shown to the customer when ordering.


//        - An item group contains a selected item (id), an amount and a shipping date.


//        - The shipping date should be calculated automatically:
//        - When we have the item in stock, the shipping date is set to the next day
//        - Otherwise the shipping date should be set to next week


//        - Question: should an order keep a reference to an item or should it make some sort of copy?
//        - Tip: Imagine that the price of the item changes over time
//        - Prioritization: Must-Have