package com.kata.demoKata;

import Utils.DateFormatter;
import entity.Amount;
import entity.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.io.PrintStream;
import java.math.BigDecimal;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TransactionTest {

    @Test
    public void getCurrentBalance_ShouldGetCurrentBalance_WhenDepositIsRun(){

        Transaction transaction = new Transaction(Amount.getAmount(new BigDecimal(100)), DateFormatter.date("24/08/2020"));
        Amount amount = transaction.getCurrentBalance(Amount.getAmount(new BigDecimal(10)));
        assertThat(amount, is(Amount.getAmount(new BigDecimal(110))));
    }

    @Mock
    private PrintStream printStream;


    @Test
    public void print_ShouldDisplayTransaction_WhenCreditIsRun(){
        Transaction transaction = new Transaction(Amount.getAmount(new BigDecimal(100)), DateFormatter.date("24/08/2020"));
        transaction.print(printStream, Amount.getAmount(new BigDecimal(100)));
        verify(printStream).println("24/08/2020 | 100,00   |          | 100,00");

    }

    @Test
    public void print_ShouldDisplayTransaction_WhenDebitIsRun(){
        Transaction transaction = new Transaction(Amount.getAmount(new BigDecimal(100).negate()), DateFormatter.date("24/08/2020"));
        transaction.print(printStream, Amount.getAmount(new BigDecimal(100).negate()));
        verify(printStream).println("24/08/2020 |          | 100,00   | -100,00");
    }

}