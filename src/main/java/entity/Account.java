package entity;

import exception.WithdrawalException;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Date;

/**
 * entity of account
 */
public class Account {

    private Statement statement;
    public Amount currentBalance = Amount.getAmount(new BigDecimal(0));

    public Account(Statement statement) {
        this.statement = statement;
    }

    public void setCurrentBalance(Amount currentBalance) {
        this.currentBalance = currentBalance;
    }

    /**
     * the deposit amount to account
     *
     * @param amount
     * @param date
     */
    public void depositAmountFromAccount(Amount amount, Date date) {
        updateAccount(amount, date);
    }

    private void updateAccount(Amount value, Date dateTransaction) {
        Transaction transaction = new Transaction(value, dateTransaction);
        Amount AmountAfterTransaction = transaction.getCurrentBalance(currentBalance);
        currentBalance = AmountAfterTransaction;
        statement.addOperation(transaction, currentBalance);
    }

    /**
     * the withdrawal amount from account
     *
     * @param amount
     * @param date
     */
    public void withdrawalAmountFromAccount(Amount amount, Date date) throws WithdrawalException {

        if (currentBalance.getValue().compareTo(amount.getValue()) < 0) {
            throw new WithdrawalException("We don't have enough amount in your account");
        } else {
            updateAccount(amount.negativeValue(), date);
        }
    }

    /**
     * Display History transaction for account
     *
     * @param printStream
     */
    public void displayStatement(PrintStream printStream) {
        statement.print(printStream);
    }

}
