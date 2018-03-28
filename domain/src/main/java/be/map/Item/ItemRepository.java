package be.map.Item;

import be.map.Item.Item;

import java.util.ArrayList;

public class ItemRepository {

    private ArrayList<Item> items;
    private int uniqueCounter;

    private ItemRepository itemRepository;

    public ItemRepository() {
        this.items = new ArrayList<Item>();
    }

    public ItemRepository(ArrayList<Item> items) {
        this.items = items;
    }

    //### Story 3: Add an item
    //As an admin user I want to add an item so I can expand the list of available items.
    //- When adding an Item, the following data should be provided
    //    - Name
    //    - Description
    //    - Price
    //    - Amount (stock)
    //- Prioritization: Must-Have
    //

    public Item addItem(Item item) {
        uniqueCounter++;
        items.add(item);
        return item;
    }

    //### Story 4: Update an item
    //As an admin user I want to update an item so I can keep my list of available items up to date.
    //- When updating an Item, the following data can be provided
    //    - Name
    //    - Description
    //    - Price
    //    - Amount (stock)
    //- Prioritization: Must-Have

    public Item updateItem(Item afterItem) {
        for (Item item : itemRepository.getItems()) {
            if (item.getId() == afterItem.getId()) {
                items.remove(item);
                items.add(afterItem);
            }
        }
        return afterItem;
    }


    public ArrayList<Item> getItems() {
        return items;
    }

    public int getUniqueCounter() {
        return uniqueCounter;
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


    //- I should be able to provide a filter, selecting only the items that have a certain level. --> STREAMS
    //    - E.g.: Give me the list of items with urgency indicator STOCK_LOW
    //- Prioritization: Must-Have


}
