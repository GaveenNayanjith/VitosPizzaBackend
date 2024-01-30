package com.vitosonline.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vitosonline.dtos.PizzaDto;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Table(name = "pizza")
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Category category;

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
