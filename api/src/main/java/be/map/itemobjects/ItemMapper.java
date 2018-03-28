package be.map.itemobjects;

import be.map.Item.Item;

public class ItemMapper {

    public static ItemDto itemToDto(Item itemToMap) {
        return new ItemDto()
                .withId(itemToMap.getId())
                .withName(itemToMap.getName())
                .withDescription(itemToMap.getDescription())
                .withPrice(itemToMap.getPrice())
                .withStock(itemToMap.getStock())
                .withItemRepository(itemToMap.getItemRepository());
    }

    public static Item dtoToItem(ItemDto item) {
        return new Item(item.name, item.description, item.price, item.stock);
    }

}
