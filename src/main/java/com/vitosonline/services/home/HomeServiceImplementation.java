package com.vitosonline.services.home;

import com.vitosonline.dtos.CategoryDto;
import com.vitosonline.dtos.PizzaDto;
import com.vitosonline.entities.Category;
import com.vitosonline.entities.Pizza;
import com.vitosonline.repositories.CategoryRepository;
import com.vitosonline.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeServiceImplementation implements HomeService{

    @Autowired
    private final PizzaRepository pizzaRepository;

    private final CategoryRepository categoryRepository;

    public HomeServiceImplementation(PizzaRepository pizzaRepository, CategoryRepository categoryRepository) {
        this.pizzaRepository = pizzaRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<PizzaDto> getAllPizzaDto(Long categoryId) {
        return pizzaRepository.findAllByCategoryId(categoryId).stream().map(Pizza::getPizzaDto).collect(Collectors.toList());
    }


    @Override
    public List<CategoryDto> getAllCategoryDto() {
        return categoryRepository.findAll().stream().map(Category::getCategoryDto).collect(Collectors.toList());
    }
}
