package entity;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Objects;

/**
 * entity of transaction amount
 */
public class Amount {

    private BigDecimal value;

    /**
     * amount construct
     *
     * @param value
     */
    public Amount(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        Amount amountTmp = (Amount) o;
        if (value.compareTo(amountTmp.value) == 0)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    /**
     *
     * @param val : amount
     * @return current Amount
     */
    public static Amount getAmount(BigDecimal val){
        return new Amount(val);
    }

    public static Amount setAmount(BigDecimal val){
        return new Amount(val);
    }

    /**
     * added new amount to account
     * @param other : amount to added to the current value
     * @return Amount
     */
    public Amount addAmountValue(Amount other) {
        return getAmount(this.value.add(other.value));
    }

    /**
     * Get negative amount
     * @return Amount
     */
    public Amount negativeValue(){
        return getAmount(value.negate());
    }

    // pattern (#): if we have 0 or nothing result value, then put nothing before .
    private DecimalFormat decimalFormat = new DecimalFormat("#.00");

    /**
     * Get the absolut amount value for display it
     * @return
     */
    public Amount absolutAmount(){
        return Amount.getAmount(value.abs());
    }

    public String formatDisplayedAmount(){
        return decimalFormat.format(value);
    }

    /**
     * check if the value of amount is greater than the  older
     * @param amount
     * @return
     */
    public boolean checkAmount(Amount amount) {
        return this.value.compareTo(amount.value) > 0 ;
    }
}
