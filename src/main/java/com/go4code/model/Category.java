package com.go4code.model;

import javax.persistence.*;

@Entity
@Table(catalog = "dbrestaurant", name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameCategory;

    public Category() {
    }

    public Category(Long id, String nameCategory) {
        this.id = id;
        this.nameCategory = nameCategory;
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

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", nameCategory='" + nameCategory + '\'' +
                '}';
    }
}
