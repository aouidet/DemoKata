package entity;

import java.io.PrintStream;
import java.util.Date;

/**
 * entity of account
 */
public class Account {

    private Statement statement;
    private Amount currentBalance = Amount.getAmount(0);

    public Account(Statement statement){
        this.statement = statement;
    }

    /**
     * the deposit amount to account
     * @param amount
     * @param date
     */
    public void depositAmountFromAccount(Amount amount, Date date){
        updateAccount(amount, date);
    }

    private void updateAccount(Amount value, Date dateTransaction){
        Transaction transaction = new Transaction(value, dateTransaction);
        Amount AmountAfterTransaction = transaction.getCurrentBalance(currentBalance);
        currentBalance = AmountAfterTransaction;
        statement.addOperation(transaction, currentBalance);
    }

    /**
     * the withdrawal amount from account
     * @param amount
     * @param date
     */
    public void withdrawalAmountFromAccount(Amount amount, Date date){
        updateAccount(amount.negativeValue(), date);
    }

    /**
     * Display History transaction for account
     * @param printStream
     */
    public void displayStatement(PrintStream printStream){
        statement.print(printStream);
    }

}
