package com.vitosonline.repositories;

import com.vitosonline.dtos.PizzaDto;
import com.vitosonline.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza,Long> {
    List<Pizza> findAllByCategoryId(Long categoryId);
}
