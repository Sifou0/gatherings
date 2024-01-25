package com.learning.crud.food.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Nutriments{
    private double carbohydrates;
    private double carbohydrates100g;
    private String carbohydratesUnit;
    private double carbohydratesValue;
    private int energy;
    private int energyKcal;
    private int energyKcal100g;
    private String energyKcalUnit;
    private int energyKcalValue;
    private double energyKcalValueComputed;
    private int energy100g;
    private String energyUnit;
    private int energyValue;
    private double fat;
    private double fat100g;
    private String fatUnit;
    private double fatValue;
    private int fruitsVegetablesLegumesEstimateFromIngredients100g;
    private int fruitsVegetablesLegumesEstimateFromIngredientsServing;
    private double fruitsVegetablesNutsEstimateFromIngredients100g;
    private double fruitsVegetablesNutsEstimateFromIngredientsServing;
    private int novaGroup;
    private int novaGroup100g;
    private int novaGroupServing;
    private int nutritionScoreFr;
    private int nutritionScoreFr100g;
    private double proteins;
    private double proteins100g;
    private String proteinsUnit;
    private double proteinsValue;
    private double salt;
    private double salt100g;
    private String saltUnit;
    private double saltValue;
    private double saturatedFat;
    private double saturatedFat100g;
    private String saturatedFatUnit;
    private double saturatedFatValue;
    private double sodium;
    private double sodium100g;
    private String sodiumUnit;
    private double sodiumValue;
    private double sugars;
    private double sugars100g;
    private String sugarsUnit;
    private double sugarsValue;

}