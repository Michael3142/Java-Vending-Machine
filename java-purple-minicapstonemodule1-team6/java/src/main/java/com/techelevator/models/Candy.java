package com.techelevator.models;

import java.math.BigDecimal;

public class Candy extends Goods {
    public Candy(String slot, String name, BigDecimal price) {
    super(slot, name, price, "Candy");
}

    @Override
    public void displayInformation() {
        System.out.println("Candy");
    }
}


