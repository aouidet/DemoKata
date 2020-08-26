package com.kata.demoKata;

import Utils.DateFormatter;
import entity.Amount;
import entity.Operation;
import entity.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;
import java.io.PrintStream;

@RunWith(MockitoJUnitRunner.class)
public class OperationTest {

    @Mock
    private PrintStream printStream;

    @Test
    public void displayOperations_shouldDisplayOperation_WhenDepositAmount(){
        Transaction matcherTransaction = new Transaction(Amount.getAmount(1000), DateFormatter.date("24/08/2020"));
        Operation operation = new Operation(matcherTransaction, Amount.getAmount(1000));
        operation.displayOperations(printStream);
        verify(printStream).println("24/08/2020 | 1000,00  |          | 1000,00");

    }

    @Test
    public void displayOperations_shouldDisplayOperation_WhenCreditAmount(){
        Transaction matcherTransaction = new Transaction(Amount.getAmount(-1000), DateFormatter.date("24/08/2020"));
        Operation operation = new Operation(matcherTransaction, Amount.getAmount(-1000));
        operation.displayOperations(printStream);
        verify(printStream).println("24/08/2020 |          | 1000,00  | -1000,00");

    }
}
