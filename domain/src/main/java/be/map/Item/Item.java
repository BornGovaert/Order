package be.map.Item;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Item {

    private int id;

    private String name;
    private String description;
    private double price;
    private int stock = 1;

    private ItemRepository itemRepository;

    public Item(String name, String description, double price, int stock) {
        this.id = itemRepository.getUniqueCounter();
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return stock;
    }

    public void setAmount(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public ItemRepository getItemRepository() {
        return itemRepository;
    }

    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    //### Story 10:
    //As an admin user I want to have an overview of items and their stock resupply urgency so I can resupply items in a timely matter.
    //- To indicate the urgency of stock resupply we need to use a very business specific urgency indicator.
    //- There are 3 different levels for the urgency indicator:
    //    - STOCK_LOW
    //        - If item amount < 5 and item was ordered in the last 7 days
    //        - If item amount < 3
    //    - STOCK_MEDIUM
    //        - If item amount < 10
    //    - STOCK_HIGH
    //        -  If item amount >= 10
    //- The list of items should be ordered based on stock resupply urgency. Starting from most urgent to less urgent.
    //- I should be able to provide a filter, selecting only the items that have a certain level.
    //    - E.g.: Give me the list of items with urgency indicator STOCK_LOW
    //- Prioritization: Must-Have

}
