package com.learning.crud.food.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "food_item")
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String productName;
    private String allergens;
    private String code;
    private String imageUrl;
    private int novaGroup;
    private Nutriscore nutriscoreData;
    private Nutriments nutriments;

}
