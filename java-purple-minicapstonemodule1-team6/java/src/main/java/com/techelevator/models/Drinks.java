package com.techelevator.models;

import java.math.BigDecimal;

public class Drinks extends Goods {
    public Drinks(String slot, String name, BigDecimal price) {
        super(slot, name, price, "Drinks");
    }

    @Override
    public void displayInformation() {
        System.out.println("Crunch");
    }
}


