package entity;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

public class Statement {

    /**
     * list of operations
     */
    private List<Operation> operationList = new LinkedList<>();
    private static final String HEADERS = "date       | credit   | debit    | balance" ;

    /**
     * add operation with transaction and currentAmount
     * @param transaction
     * @param currentBalance
     */
    public void addOperation(Transaction transaction, Amount currentBalance){
        operationList.add(0, new Operation(transaction, currentBalance));
        operationList.stream().forEach(x-> System.out.println(x.getAmount().getValue()));
    }

    public void print(PrintStream printStream){
        printStream.println(HEADERS);
        printOperation(printStream);
    }

    private void printOperation(PrintStream printStream){
        operationList.stream().forEach(e->e.displayOperations(printStream));
    }
}
