package com.vitosonline.dtos;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PizzaDto {
    private long id;

    private String name;

    private String price;

    private String description;

}
