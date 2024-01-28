package com.vitosonline.services.home;

import com.vitosonline.dtos.PizzaDto;
import com.vitosonline.entities.Pizza;
import com.vitosonline.repositories.PizzaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeServiceImplementation implements HomeService{

    private PizzaRepository pizzaRepository;
    @Override
    public List<PizzaDto> getAllPizza() {
        return pizzaRepository.getAllPizza().stream().map(Pizza::getPizzaDto).collect(Collectors.toList());
    }
}
