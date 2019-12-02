package com.thebetadecays.SC_Model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Expense Object will be used by Model to create records of user logged expenses
 * @author Skyler Novak
 */
public class Expense {

    // private fields of Expense object
    private Money amount;
    private ZonedDateTime dateTime;
    private String contact;
    private String category;
    private String subcategory;
    private String memo;

    /**
     * Default Constructor
     * initialises all values to default null value
     * @author Skyler Novak
     */
    Expense() {
        amount = new Money(0);
        dateTime.toLocalDateTime(); // is this correct?
        contact = "";
        category = "";
        // delete the two following?
        subcategory = "";
        memo = "";
    } // Expense()

    /**
     * Accepts 7 string parameters. will convert to appropriate data type and initialize class.
     * argument format: dollar\tcent\tZonedatetime\tcontact\tcategory\tsubCategory\tmemo\n
     * @param nextToken dollar for Money object
     * @param nextToken1 cent for Money object
     * @param nextToken2 dateTime
     * @param nextToken3 contact name
     * @param nextToken4 category
     * @param nextToken5 subcategory
     * @param nextToken6 memo
     * @author Skyler Novak
     */
    public Expense(String nextToken, String nextToken1, String nextToken2, String nextToken3,
                   String nextToken4, String nextToken5, String nextToken6) {

        // Initialise Expense object
        amount = new Money(nextToken + nextToken1);
        dateTime = ZonedDateTime.of(LocalDateTime.parse(nextToken2), ZoneId.of("PST")); // Does this work?
        contact = nextToken3;
        category = nextToken4;
        subcategory = nextToken5;
        memo = nextToken6;

    } // Expense(String, String, String, String, String, String, String)

    // Accessors

    /**
     * getter for amount : Money
     * @return amount (required)
     * @author Skyler Novak
     */
    public Money getAmount() {
        return amount;
    }

    /**
     * getter for dateTime : ZonedDateTime
     * @return dateTime (required)
     * @author Skyler Novak
     */
    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    /**
     * getter for contact : String
     * @return contact (required)
     * @author Skyler Novak
     */
    public String getContact() {
        return contact;
    }

    /**
     * getter for category : String
     * @return category (required)
     * @author Skyler Novak
     */
    public String getCategory() {
        return category;
    }

    /**
     * Getter for subcategory : String
     * @return subcategory (required)
     * @author Skyler Novak
     */
    public String getSubcategory() {
        return subcategory;
    }

    /**
     * getter for memo : String
     * @return memo (required)
     * @author Skyler Novak
     */
    public String getMemo() {
        return memo;
    }


    // Mutators

    /**
     * setter for amount : Money
     * @param amt  --  SC defined object for handling monetary transactions
     * @author Skyler Novak
     */
    public void setAmount(Money amt) {
        this.amount.setDollar(amt.getDollar());
        this.amount.setCent(amt.getCent());
    }

    /**
     * Setter for dateTime : ZonedDateTime
     * @param dateTime  --  time stamp for transactions
     * @author Skyler Novak
     */
    public void setDateTime(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * setter for contact : String
     * @param contact  --  Name of contact
     * @author Skyler Novak
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * setter for category : String
     * @param category  --  String name of category
     * @author Skyler Novak
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * setter for subcategory : String
     * @param subcategory  --  subcategory of the category type
     * @author Skyler Novak
     */
    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    /**
     * setter for memo : String
     * @param memo  --  Notes that user may attach to transaction
     * @author Skyler Novak
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     *
     * @return
     */
    public String toTSV() {

        // String format: dollar\tcent\tZonedatetime\tcontact\tcategory\tsubCategory\tmemo\n
        return String.format("%s\t%s\t%s\t%s\t%s\t%s",
                this.getAmount().toString(),
                this.getDateTime().toString(),
                this.getContact(),
                this.getCategory(),
                this.getSubcategory(),
                this.getSubcategory()
        ); // return statement

    } // toTSV()

} // Expense
