package com.techelevator.models;

import java.math.BigDecimal;

public class Gum extends Goods {
    public Gum(String slot, String name, BigDecimal price) {
        super(slot, name, price, "Gum");
    }

    @Override
    public void displayInformation() {
        System.out.println("Crunch");
    }
}


