package be.map.itemobjects;

import be.map.Item.Item;
import be.map.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/items")
public class ItemController {

    private ItemService itemService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto createItem(@RequestBody ItemDto item) {
        return ItemMapper.itemToDto(itemService.addItem(ItemMapper.dtoToItem(item)));
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ItemDto updateItem(@RequestBody ItemDto item) {
        return ItemMapper.itemToDto(itemService.updateItem(ItemMapper.dtoToItem(item)));
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDto> getItems() {
        ArrayList<ItemDto> itemsDto = new ArrayList<>();
        for (Item item : itemService.getItems()) {
            itemsDto.add(ItemMapper.itemToDto(item));
        }
        return itemsDto;
    }
}
