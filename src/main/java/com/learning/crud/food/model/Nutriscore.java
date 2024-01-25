package com.learning.crud.food.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Nutriscore {
    private int energy;
    private int energyPoints;
    private int energyValue;
    private int fiber;
    private int fiberPoints;
    private int fiberValue;
    private double fruitsVegetablesNutsColzaWalnutOliveOils;
    private int fruitsVegetablesNutsColzaWalnutOliveOilsPoints;
    private double fruitsVegetablesNutsColzaWalnutOliveOilsValue;
    private String grade;
    private int isBeverage;
    private int isCheese;
    private int isFat;
    private int isWater;
    private int negativePoints;
    private int positivePoints;
    private double proteins;
    private int proteinsPoints;
    private double proteinsValue;
    private double saturatedFat;
    private int saturatedFatPoints;
    private double saturatedFatValue;
    private int score;
    private int sodium;
    private int sodiumPoints;
    private int sodiumValue;
    private double sugars;
    private int sugarsPoints;
    private double sugarsValue;

}
