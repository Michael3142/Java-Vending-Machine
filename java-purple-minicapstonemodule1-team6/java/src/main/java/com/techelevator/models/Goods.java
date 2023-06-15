package com.techelevator.models;

import java.math.BigDecimal;

public abstract class Goods {
    // A1,U-Chews,1.65,Gum
    private String slot;
    private String name;
    private BigDecimal price;
    private String type;
    private int quantity = 0;

    public Goods(String slot, String name, BigDecimal price, String type) {
        this.slot = slot;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = 6;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity() {
        if (quantity > 0) {
            this.quantity -= 1;
        } else {

        }
    }
    public abstract void displayInformation();


    @Override
    public String toString() {
        return  slot +
                " || " + name +
                " || " + price +
                " || " + type
                ;
    }
}


