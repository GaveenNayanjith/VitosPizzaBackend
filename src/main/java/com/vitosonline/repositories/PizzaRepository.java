package com.vitosonline.repositories;

import com.vitosonline.dtos.PizzaDto;
import com.vitosonline.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza,Long> {

    List<Pizza> getAllPizza();
}
