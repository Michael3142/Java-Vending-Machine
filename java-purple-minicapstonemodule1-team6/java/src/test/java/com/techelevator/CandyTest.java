package com.techelevator;

import com.techelevator.models.Candy;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CandyTest {

    @Test
    public void candy_get_name_is_correct(){
        Candy candyTest = new Candy("A1", "test", new BigDecimal("2.00"));
        Assert.assertEquals("test", candyTest.getName());

    }

    @Test
    public void candy_price_is_correct() {
        Candy candyTest = new Candy("A1", "test", new BigDecimal("2.00"));
        Assert.assertEquals(new BigDecimal("2.00"), candyTest.getPrice());
    }

    @Test
    public void candy_message_is_correct() {
        Candy candyTest = new Candy("A1", "test", new BigDecimal("2.00"));
        String candyMessage = "Candy";

        Assert.assertEquals(candyMessage, candyTest.getType());

    }

}
