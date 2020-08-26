package com.kata.demoKata;

import Utils.DateFormatter;
import entity.Amount;
import entity.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class TransactionTest {

    @Test
    public void getCurrentBalance_ShouldGetCurrentBalance_WhenDepositIsRun(){

        Transaction transaction = new Transaction(Amount.getAmount(100), DateFormatter.date("24/08/2020"));
        Amount amount = transaction.getCurrentBalance(Amount.getAmount(10));
        assertThat(amount, is(Amount.getAmount(110)));
    }

}