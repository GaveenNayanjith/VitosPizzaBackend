package com.vitosonline.services.home;

import com.vitosonline.dtos.CategoryDto;
import com.vitosonline.dtos.PizzaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HomeService {

    List<PizzaDto> getAllPizzaDto(Long categoryId);

    List<CategoryDto> getAllCategoryDto();
}
