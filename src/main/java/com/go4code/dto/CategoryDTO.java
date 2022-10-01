package com.go4code.dto;

import com.go4code.model.Category;

public class CategoryDTO {
    Long id;

    String nameCategory;

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.nameCategory = category.getNameCategory();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
