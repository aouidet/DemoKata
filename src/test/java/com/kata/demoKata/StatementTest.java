package com.kata.demoKata;

import Utils.DateFormatter;
import entity.Amount;
import entity.Statement;
import entity.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.io.PrintStream;
import java.math.BigDecimal;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatementTest {

    @Mock
    private PrintStream printStream;

    private Statement statement;

    @Before
    public void init() {
        statement = new Statement();
    }

    @Test
    public void print_ShouldDisplayHeader() {
        String HEADERS = "date       | credit   | debit    | balance";
        statement.print(printStream);
        verify(printStream).println(HEADERS);
    }

    @Test
    public void print_ShouldDisplayDepositTransaction() {

        Transaction matcherTransaction = new Transaction(Amount.getAmount(new BigDecimal(100)), DateFormatter.date("24/08/2020"));

        statement.addOperation(matcherTransaction, Amount.getAmount(new BigDecimal(100)));
        statement.print(printStream);
        verify(printStream).println("24/08/2020 | 100,00   |          | 100,00");
    }

    @Test
    public void print_ShouldDisplayWithdrawalTransaction() {

        Transaction matcherTransaction = new Transaction(Amount.getAmount(new BigDecimal(100).negate()), DateFormatter.date("25/08/2020"));

        statement.addOperation(matcherTransaction, Amount.getAmount(new BigDecimal(100).negate()));
        statement.print(printStream);
        verify(printStream).println("25/08/2020 |          | 100,00   | -100,00");
    }
}
