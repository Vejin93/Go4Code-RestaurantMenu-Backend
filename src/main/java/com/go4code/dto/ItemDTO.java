package com.go4code.dto;

import com.go4code.model.Category;
import com.go4code.model.Item;


public class ItemDTO {
    Long id;
    String name;
    Category category;
    int price;

    public ItemDTO() {
    }

    public ItemDTO(Long id, String name, Category category, int price) {
        super();
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public ItemDTO(Item item) {
        super();
        this.id = item.getId();
        this.name = item.getName();
        this.category = item.getCategory();
        this.price = item.getPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
