package com.go4code.service;

import com.go4code.data.CategoryRepository;
import com.go4code.data.ItemRespository;
import com.go4code.model.Category;
import com.go4code.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemService {
    @Autowired
    ItemRespository itemRespository;

    @Autowired
    CategoryRepository categoryRepository;

    public List<Item> findAll(){return itemRespository.findAll();}

    public Item findById(Long id){return itemRespository.findById(id).get();}

    public List<Item> findByNameContains(String name){return itemRespository.findByNameContains(name);}

    public Item save(Item item){return itemRespository.save(item);}

    public void deleteAllById(Long id){itemRespository.deleteById(id);}

    public List<Item> findByCategoryContains(String nameCategory) {
        Category category = categoryRepository.findByNameCategoryIgnoreCaseContains(nameCategory);
        return itemRespository.findByCategory(category);
    }

}
