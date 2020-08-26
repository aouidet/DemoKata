package entity;

import java.util.Objects;

/**
 * entity of transaction amount
 */
public class Amount {

    private int value;

    /**
     * amount construct
     *
     * @param value
     */
    public Amount(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        Amount amountTmp = (Amount) o;
        if (value == amountTmp.value)
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
    public static Amount getAmount(int val){
        return new Amount(val);
    }

    /**
     * added new amount to account
     * @param other
     * @return
     */
    public Amount addAmountValue(Amount other) {
        return getAmount(this.value + other.value);
    }

}
