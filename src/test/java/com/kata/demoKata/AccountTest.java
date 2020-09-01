package com.kata.demoKata;

import Utils.DateFormatter;
import entity.Account;
import entity.Amount;
import entity.Statement;
import entity.Transaction;
import exception.WithdrawalException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Date;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    @Mock
    private Statement statement;

    private Account account;

    private Amount amount;

    @Before
    public void init() {
        account = new Account(statement);
    }


    @Test
    public void depositAmountFromAccount_ShouldAddDepositAmount() {

        Amount amountDeposit = Amount.getAmount(new BigDecimal(1000));
        Date dateDeposit = DateFormatter.date("24/08/2020");

        account.depositAmountFromAccount(amountDeposit, dateDeposit);
        Transaction matcherTransaction = new Transaction(Amount.getAmount(new BigDecimal(1000)), dateDeposit);
        statement.addOperation(matcherTransaction, Amount.getAmount(new BigDecimal(1000)));
        verify(statement, times(1)).addOperation(matcherTransaction, Amount.getAmount(new BigDecimal(1000)));
    }

    @Test
    public void withdrawalAmountFromAccount_ShouldThrowException_WhenWeDontHaveEnoughAmount() {

        Amount amountWathdrawal = Amount.getAmount(new BigDecimal(50));
        Date dateDeposit = DateFormatter.date("25/08/2020");
        Amount.setAmount(new BigDecimal(100));
        try {
            account.withdrawalAmountFromAccount(amountWathdrawal, dateDeposit);
        }catch (WithdrawalException e){
            assert (e.getMessage().contains("We don't have enough amount in your account"));
        }
    }

    @Test
    public void withdrawalAmountFromAccount_ShouldThrowException_WhenWeHaveEnoughAmountInAccount() {

        account.depositAmountFromAccount(Amount.getAmount(new BigDecimal(100)),DateFormatter.date("25/08/2020"));

        Amount amountWathdrawal = Amount.getAmount(new BigDecimal(50));
        Date dateDeposit = DateFormatter.date("25/08/2020");

        try {
            account.withdrawalAmountFromAccount(amountWathdrawal, dateDeposit);
        }catch (WithdrawalException e){
            assert (e.getMessage().contains("your balance is insufficient"));
        }
        Transaction matcherTransaction = new Transaction(Amount.getAmount(new BigDecimal(50).negate()), dateDeposit);
        statement.addOperation(matcherTransaction, amountWathdrawal);
        verify(statement, times(1)).addOperation(matcherTransaction, Amount.getAmount(new BigDecimal(50)));
    }

    @Test
    public void displayStatement_ShouldDisplayStatement() {

        PrintStream printStream = System.out;
        account.displayStatement(printStream);
        verify(statement).print(printStream);
    }

}
