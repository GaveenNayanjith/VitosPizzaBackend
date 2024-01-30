package com.vitosonline.controllers;

import com.vitosonline.dtos.CategoryDto;
import com.vitosonline.dtos.PizzaDto;
import com.vitosonline.services.home.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizza")
@RequiredArgsConstructor
@CrossOrigin
public class HomeController {

    private final HomeService homeService;

    @GetMapping("/get-all-cat")
    public ResponseEntity<List<CategoryDto>> getAllCategory(){
        List<CategoryDto> categoryDtoList = homeService.getAllCategoryDto();
        if (categoryDtoList == null) return  ResponseEntity.notFound().build();
        return ResponseEntity.ok(categoryDtoList);
    }

    @GetMapping("/{categoryId}/get-all-pizza")
    public ResponseEntity<List<PizzaDto>> getAllPizza(@PathVariable Long categoryId) {
        List<PizzaDto> pizzaDtoList = homeService.getAllPizzaDto(categoryId);
        if (pizzaDtoList == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pizzaDtoList);
    }
}
