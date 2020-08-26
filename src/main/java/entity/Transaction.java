package entity;

import java.util.Date;

/**
 * entity of transaction
 */
public class Transaction {

    private Amount amount;
    private Date dateTransaction;

    public Transaction(Amount amount, Date dateTransaction){
        this.amount = amount;
        this.dateTransaction = dateTransaction;
    }

    /**
     * get balance after transaction
     * @param balance
     * @return
     */
    public Amount getCurrentBalance(Amount balance){
        return balance.addAmountValue(amount);
    }
}
