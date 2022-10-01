package com.go4code.service;

import com.go4code.data.CategoryRepository;
import com.go4code.model.Category;
import com.go4code.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findAll(){return categoryRepository.findAll();}
}
