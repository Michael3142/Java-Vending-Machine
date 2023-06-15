package com.techelevator;

import com.techelevator.models.Candy;
import com.techelevator.models.Gum;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class GumTest {

    @Test
    public void gum_get_name_is_correct(){
        Gum gumTest = new Gum("A1", "test", new BigDecimal("2.00"));
        Assert.assertEquals("test", gumTest.getName());

    }

    @Test
    public void gum_price_is_correct() {
        Gum gumTest = new Gum("A1", "test", new BigDecimal("2.00"));
        Assert.assertEquals(new BigDecimal("2.00"), gumTest.getPrice());
    }

    @Test
    public void gum_message_is_correct() {
        Gum gumTest = new Gum("A1", "test", new BigDecimal("2.00"));
        String gumMessage = "Gum";

        Assert.assertEquals(gumMessage, gumTest.getType());

    }





}
