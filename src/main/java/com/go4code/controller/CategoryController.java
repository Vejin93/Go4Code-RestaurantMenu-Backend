package com.go4code.controller;

import com.go4code.dto.CategoryDTO;
import com.go4code.dto.ItemDTO;
import com.go4code.model.Category;
import com.go4code.model.Item;
import com.go4code.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value="api/categories", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getCategories(){
        List<Category> categories = categoryService.findAll();
        List<CategoryDTO> retVal = convertCategoryToDTOs(categories);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @RequestMapping(value="api/nameCategories", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getNameCategories(){
        List<Category> categories = categoryService.findAll();
        List<String> retVal = new ArrayList<String>();
        for(Category c: categories){
            retVal.add(c.getNameCategory());
        }
        return new ResponseEntity<>(retVal, HttpStatus.OK);
    }

    private List<CategoryDTO> convertCategoryToDTOs(List<Category> categories) {
        List<CategoryDTO> retVal = new ArrayList<>();
        for (Category category: categories) {
            CategoryDTO categoryDTO = new CategoryDTO(category);
            retVal.add(categoryDTO);
        }
        return retVal;
    }
}
