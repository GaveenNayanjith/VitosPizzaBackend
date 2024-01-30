package com.vitosonline.entities;

import com.vitosonline.dtos.CategoryDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;

    private String description;

    public CategoryDto getCategoryDto(){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(id);
        categoryDto.setCategoryName(categoryName);
        categoryDto.setDescription(description);
        return categoryDto;
    }
}
