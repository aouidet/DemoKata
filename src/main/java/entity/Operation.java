package entity;

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
}
