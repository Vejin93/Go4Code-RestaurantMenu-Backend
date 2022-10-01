package com.go4code.data;

import com.go4code.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    public Category findByNameCategoryIgnoreCaseContains(String nameCategory);
}
