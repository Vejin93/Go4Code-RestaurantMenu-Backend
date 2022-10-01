package com.go4code.data;

import com.go4code.model.Category;
import com.go4code.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRespository extends JpaRepository<Item,Long> {

    public List<Item> findByNameContains(String name);

    public List<Item> findByCategory(Category category);
}
