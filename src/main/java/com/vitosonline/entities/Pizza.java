package com.vitosonline.entities;

import com.vitosonline.dtos.PizzaDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String price;

    private String description;

    private byte[] img;

    public PizzaDto getPizzaDto(){
        PizzaDto pizzaDto = new PizzaDto();
        pizzaDto.setId(id);
        pizzaDto.setName(name);
        pizzaDto.setPrice(price);
        pizzaDto.setDescription(description);
        pizzaDto.setReturnedImg(img);
        return pizzaDto;

    }

}
