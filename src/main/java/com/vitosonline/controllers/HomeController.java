package com.vitosonline.controllers;

import com.vitosonline.dtos.PizzaDto;
import com.vitosonline.services.home.HomeService;
import com.vitosonline.services.home.HomeServiceImplementation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class HomeController {

    private HomeService homeService;

    @PostMapping("")
    public ResponseEntity<List<PizzaDto>> getAllPizza(){
        List<PizzaDto> pizzaDtoList = homeService.getAllPizza();
        return ResponseEntity.ok(pizzaDtoList);
    }
}
