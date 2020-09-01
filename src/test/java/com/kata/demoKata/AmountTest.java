package com.kata.demoKata;

import entity.Amount;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class AmountTest {

    @Test
    public void AmountConstructor_shouldBeEqual_whenWeHaveTheSameAmount(){
        Amount firstAmount = new Amount(new BigDecimal(100));
        Amount secondAmount = new Amount(new BigDecimal(100));
        assertEquals(firstAmount, secondAmount);
    }

    @Test
    public void AmountConstructor_ShouldBeDifferent_WhenTheAmountIsDifferent(){
        Amount firstAmount = new Amount(new BigDecimal(100));
        Amount secondAmount = new Amount(new BigDecimal(200));
        assertNotEquals(firstAmount, secondAmount);
    }

    @Test
    public void getAmount_ShouldGetAmount(){
        assertEquals(new Amount(new BigDecimal(100)), Amount.getAmount(new BigDecimal(100)));
    }

    @Test
    public void addAmount_ShouldAddAmountAfterTransaction(){

        Amount currentAmount = Amount.getAmount(new BigDecimal(60));
        Amount addedAmount = Amount.getAmount(new BigDecimal(40));
        assertEquals(new Amount(new BigDecimal(100)), currentAmount.addAmountValue(addedAmount));
    }

    @Test
    public void negativeValue_ShouldGetAmount_WhenWeHaveNegativeValue(){
        Amount amount = new Amount(new BigDecimal(100));
        assertEquals(amount.negativeValue().getValue(), new BigDecimal(100).negate());
    }

    @Test
    public void absolutAmount_ShouldGetAbsolutAmountValue(){

        Amount amount = new Amount(new BigDecimal(100).negate());
        assertEquals(amount.absolutAmount().getValue(), new BigDecimal(100));
    }

    @Test
    public void FormatDisplayedAmount_ShouldGetRepresentativeDicimalFormat(){
        Amount amount = new Amount(new BigDecimal(100));
        assertEquals(amount.formatDisplayedAmount(), "100,00");
    }
}
