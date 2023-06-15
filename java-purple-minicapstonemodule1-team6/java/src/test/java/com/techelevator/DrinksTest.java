package com.techelevator;

import com.techelevator.models.Candy;
import com.techelevator.models.Drinks;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class DrinksTest {

    @Test
    public void drinks_get_name_is_correct(){
        Drinks drinkTest = new Drinks("A1", "test", new BigDecimal("2.00"));
        Assert.assertEquals("test", drinkTest.getName());

    }

    @Test
    public void drinks_price_is_correct() {
        Drinks drinkTest = new Drinks("A1", "test", new BigDecimal("2.00"));
        Assert.assertEquals(new BigDecimal("2.00"), drinkTest.getPrice());
    }

    @Test
    public void drinks_message_is_correct() {
        Drinks drinkTest = new Drinks("A1", "test", new BigDecimal("2.00"));
        String candyMessage = "Drinks";

        Assert.assertEquals(candyMessage, drinkTest.getType());

    }

}
