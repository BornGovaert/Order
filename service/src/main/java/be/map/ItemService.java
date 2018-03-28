package be.map;

import be.map.Item.Item;
import be.map.Item.ItemRepository;

import javax.inject.Inject;
import java.util.ArrayList;

public class ItemService {

    private ItemRepository itemRepository;

    @Inject
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    public Item addItem(Item item) {
        return itemRepository.addItem(item);
    }

    public Item updateItem( Item item) {
        return itemRepository.updateItem(item);
    }

    public ArrayList<Item> getItems() {
        return itemRepository.getItems();
    }

}
