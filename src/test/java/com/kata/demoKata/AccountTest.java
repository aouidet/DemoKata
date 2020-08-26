package com.kata.demoKata;

import Utils.DateFormatter;
import entity.Account;
import entity.Amount;
import entity.Statement;
import entity.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.io.PrintStream;
import java.util.Date;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    @Mock
    private Statement statement;

    private Account account;

    @Before
    public void init() {
        account = new Account(statement);
    }


    @Test
    public void depositAmountFromAccount_ShouldAddDepositAmount() {

        Amount amountDeposit = Amount.getAmount(1000);
        Date dateDeposit = DateFormatter.date("24/08/2020");

        account.depositAmountFromAccount(amountDeposit, dateDeposit);
        Transaction matcherTransaction = new Transaction(Amount.getAmount(1000), dateDeposit);
        statement.addOperation(matcherTransaction, Amount.getAmount(1000));
        verify(statement, times(1)).addOperation(matcherTransaction, Amount.getAmount(1000));
    }

}
