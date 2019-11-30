package com.thebetadecays;

import java.math.BigDecimal;

/**
*
* @author Jason Gurtz-Cayla 
*/
public class Money {
    private int dollar;
    private int cent;

    public Money(int d, int c) {
        setDollar(d);
        setCent(c);
    }

    public Money(double amt) {
       BigDecimal bd = new BigDecimal(String.valueOf(amt));
       setDollar(bd.intValue());
       setCent(bd.subtract( new BigDecimal(bd.intValue())).intValue() ); 
    }

    public String toString() {
        return String.format("%s.%s", this.getDollar(), this.getCent());
    }

    public void setDollar(int d) {
        this.dollar = d;
    }

    public void setCent(int c) {
        this.cent = c;
    }

    public int getDollar() {
        return this.dollar;
    }

    public int getCent() {
        return this.cent;
    }
}
