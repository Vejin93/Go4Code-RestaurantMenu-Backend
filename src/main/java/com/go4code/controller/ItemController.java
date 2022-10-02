package com.go4code.controller;

import com.go4code.dto.CategoryDTO;
import com.go4code.dto.ItemDTO;
import com.go4code.model.Category;
import com.go4code.model.Item;
import com.go4code.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ItemController {
    @Autowired
    ItemService itemService;

    @RequestMapping(value="api/items", method = RequestMethod.GET)
    public ResponseEntity<List<ItemDTO>> getItems(){
        List<Item> items = itemService.findAll();
        List<ItemDTO> retVal = convertItemsToDTOs(items);

        return new ResponseEntity<>(retVal, HttpStatus.OK);
    }

    @RequestMapping(value="api/items/filter", method = RequestMethod.GET)
    public ResponseEntity<List<ItemDTO>> getItemsByName(@RequestParam String name){
        List<Item> items = itemService.findByNameContains(name);
        List<ItemDTO> retVal = convertItemsToDTOs(items);

        return new ResponseEntity<>(retVal, HttpStatus.OK);
    }

    @RequestMapping(value="api/items/filterByCategory", method = RequestMethod.GET)
    public ResponseEntity<List<ItemDTO>> getItemsByCategory(@RequestParam String nameCategory){
        List<Item> items = itemService.findByCategoryContains(nameCategory);
        List<ItemDTO> retVal = convertItemsToDTOs(items);

        return new ResponseEntity<>(retVal, HttpStatus.OK);
    }

    @RequestMapping(value = "api/items/{id}", method = RequestMethod.GET)
    public ResponseEntity<ItemDTO> getCountry(@PathVariable Long id) {
        Item item = itemService.findById(id);

        if (item != null) {
            ItemDTO itemDTO = new ItemDTO(item);
            // popunjavanje i kolekcije gradova u DTO objektu
            return new ResponseEntity<>(itemDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "api/items", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemDTO> create(@RequestBody ItemDTO itemDTO) {
        Item item = new Item();
        item.setName(itemDTO.getName());
        item.setCategory(itemDTO.getCategory());
        item.setPrice(itemDTO.getPrice());

        item = itemService.save(item);

        return new ResponseEntity<>(new ItemDTO(item), HttpStatus.CREATED);
    }

    @RequestMapping(value = "api/items/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemDTO> update(@PathVariable Long id,
                                             @RequestBody ItemDTO itemDTO) {

        Item item = itemService.findById(id);
        if (item == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        item.setId(id);
        item.setName(itemDTO.getName());
        item.setCategory(itemDTO.getCategory());
        item.setPrice(itemDTO.getPrice());
        item = itemService.save(item);

        return new ResponseEntity<>(new ItemDTO(item), HttpStatus.OK);
    }

    @RequestMapping(value = "api/items/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Item item = itemService.findById(id);
        if (item != null) {
            itemService.deleteAllById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private List<ItemDTO> convertItemsToDTOs(List<Item> items) {
        List<ItemDTO> retVal = new ArrayList<>();
        for (Item item: items) {
            ItemDTO itemDTO = new ItemDTO(item);
            retVal.add(itemDTO);
        }
        return retVal;
    }
}
