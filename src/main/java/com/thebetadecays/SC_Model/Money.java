package com.thebetadecays.SC_Model;

import java.math.BigDecimal;

/**
* Money object, saving monetary value without risking rounding errors
* @author Jason Gurtz-Cayla 
*/
public class Money {
    private int dollar;
    private int cent;

    /**
    * Constructor one: dollar and cent values passed in explicitly
    * @author Jason Gurtz-Cayla 
    * @param d (required) Dollar value
    * @param c (required) Cents value
    */
    public Money(int d, int c) {
        setDollar(d);
        setCent(c);
    }

    /**
    * Constructor two: Monetary value passed in as double
    * @author Jason Gurtz-Cayla 
    * @param amt (required) Monetary value
    */
    public Money(double amt) {
       BigDecimal bd = new BigDecimal(String.valueOf(amt));
       setDollar(bd.intValue());
       setCent(bd.subtract( new BigDecimal(bd.intValue())).intValue() ); 
    }

    /**
    * Constructor three: Monetary value passed in as String
    * @author Jason Gurtz-Cayla 
    * @param amt (required) Monetary value
    */
    public Money(String amt) {
        this( Double.parseDouble(amt) );
    }

    /**
    * Returns the monetary value as a printable string
    * @author Jason Gurtz-Cayla 
    * @return Monetary value
    */
    public String toString() {
        return String.format("%s.%s", this.getDollar(), this.getCent());
    }

    /**
    * Setter for dollar amount
    * @author Jason Gurtz-Cayla 
    * @param d (required) Dollar amount
    */
    public void setDollar(int d) {
        this.dollar = d;
    }

    /**
    * Setter for cent amount
    * @author Jason Gurtz-Cayla 
    * @param c (required) Cent amount, between zero and 99
    */
    public void setCent(int c) {
        this.cent = c;
    }

    /**
    * Returns the dollar value as an integer
    * @author Jason Gurtz-Cayla 
    * @return Dollar value
    */
    public int getDollar() {
        return this.dollar;
    }

    /**
    * Returns the cent value as an integer
    * @author Jason Gurtz-Cayla 
    * @return Cent value
    */
    public int getCent() {
        return this.cent;
    }
}
