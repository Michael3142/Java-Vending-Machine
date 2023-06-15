package com.techelevator.models;

import java.math.BigDecimal;

public class Munchy extends Goods {
    public Munchy(String slot, String name, BigDecimal price) {
        super(slot, name, price, "Munchy");
    }

    @Override
    public void displayInformation() {
        System.out.println("Crunch");
    }
}
