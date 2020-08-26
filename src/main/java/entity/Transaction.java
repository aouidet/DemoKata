package entity;

import org.apache.commons.lang3.StringUtils;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
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

    public void print(PrintStream printStream, Amount balance){
        StringBuilder builder = new StringBuilder();
        addDateToBuilder(builder);
        if(amount.checkAmount(Amount.getAmount(0))){
            addCreditToBuilder(builder);
        }else{
            addDebitToBuilder(builder);
        }
        addBalance(builder, balance);
        printStream.println(builder.toString());
    }

    /**
     * add date to builder
     * @param builder
     */
    private void addDateToBuilder(StringBuilder builder){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        builder.append(simpleDateFormat.format(dateTransaction)).append(" |");
    }

    /**
     * add credit into the builder
     */
    public void addCreditToBuilder(StringBuilder builder){
        String value = " "+ amount.absolutAmount().formatDisplayedAmount();
        builder.append(StringUtils.rightPad(value,10)).append("|").append("          ");
    }

    /**
     * add the debit into the balance
     * @param builder
     */
    public void addDebitToBuilder(StringBuilder builder){
        String value = " "+ amount.absolutAmount().formatDisplayedAmount();
        builder.append("          ").append("|").append(StringUtils.rightPad(value,10));
    }

    /**
     * add Balance into the builder
     * @param builder
     * @param currentBalance
     */
    public void addBalance(StringBuilder builder, Amount currentBalance){
        builder.append("| ").append(currentBalance.formatDisplayedAmount());
    }

}
