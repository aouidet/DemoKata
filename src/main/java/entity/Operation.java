package entity;

import java.io.PrintStream;

/**
 * entity operation for transaction
 */
public class Operation {

    private Transaction transaction;
    private Amount amount;

    public Amount getAmount() {
        return amount;
    }

    public Operation(Transaction transaction, Amount amount) {
        this.transaction = transaction;
        this.amount = amount;
    }

    /**
     * Display operation method
     * @param printStream
     */
    public void displayOperations(PrintStream printStream){
        this.transaction.print(printStream, amount);

    }
}
