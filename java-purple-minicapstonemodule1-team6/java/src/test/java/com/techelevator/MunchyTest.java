package com.techelevator;

import com.techelevator.models.Candy;
import com.techelevator.models.Munchy;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class MunchyTest {

    @Test
    public void munchy_get_name_is_correct(){
        Munchy munchyTest = new Munchy("A1", "test", new BigDecimal("2.00"));
        Assert.assertEquals("test", munchyTest.getName());

    }

    @Test
    public void munchy_price_is_correct() {
        Munchy munchyTest = new Munchy("A1", "test", new BigDecimal("2.00"));
        Assert.assertEquals(new BigDecimal("2.00"), munchyTest.getPrice());
    }

    @Test
    public void munchy_message_is_correct() {
        Munchy munchyTest = new Munchy("A1", "test", new BigDecimal("2.00"));
        String munchyMessage = "Munchy";

        Assert.assertEquals(munchyMessage, munchyTest.getType());

    }



}
