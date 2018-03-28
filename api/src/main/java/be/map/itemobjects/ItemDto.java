package be.map.itemobjects;

import be.map.Item.ItemRepository;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown = true)

public class ItemDto {

    public int id;
    public String name;
    public String description;
    public double price;
    public int stock;
    public ItemRepository itemRepository;

    public ItemDto withId(int id) {
        this.id = id;
        return this;
    }

    public ItemDto withName(String name) {
        this.name = name;
        return this;
    }

    public ItemDto withDescription(String description) {
        this.description = description;
        return this;
    }

    public ItemDto withPrice(double Price) {
        this.price = price;
        return this;
    }

    public ItemDto withStock(int stock) {
        this.stock = stock;
        return this;
    }

    public ItemDto withItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
        return this;
    }

    // private int id;
    //
    //    private String name;
    //    private String description;
    //    private double price;
    //    private int stock = 1;
    //
    //    private ItemRepository itemRepository;
}
