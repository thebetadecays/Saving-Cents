package com.thebetadecays.SC_Model;

import java.util.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;

/**
* Model object, implementing the api used by the view to access and persist data
* @author Jason Gurtz-Cayla
*/
public class Model {
    ZonedDateTime budgetDate;
    Money monthlyIncome;
    String pin;
    Category king;
    ArrayList<Contact> addressBook;
    ArrayList<Expense> expenses;


    /**
    * Default constructor
    * @author Jason Gurtz-Cayla
    */
    public Model() {
        monthlyIncome = new Money(1000000.00);
        pin = "0000";
    }

    /**
    * Method which loads all the data from the persistent storage
    * @author Jason Gurtz-Cayla
    */
    private void load() throws java.io.IOException {
        king = new Category();
        king.makeCategories();
        DB.loadContacts(addressBook);
        DB.loadExpenses(expenses);
    }

    /**
    * Method which saves all the data to persistent storage
    * @author Jason Gurtz-Cayla
    */
    private void save() throws java.io.IOException {
        king.writeCategory();
        DB.saveContacts(addressBook);
        DB.saveExpenses(expenses);
    }

    /**
    * Setter for the budget date
    * @author Jason Gurtz-Cayls
    * @param dt the budget date
    */
    public void setBudgetDate(ZonedDateTime dt) {
        this.budgetDate = ZonedDateTime.now();
    }

    /**
    * Setter for monthly income
    * @author Jason Gurtz-Cayls
    * @param income the user-set monthly income
    */
    public void setMonthlyIncome(double income) {
        this.monthlyIncome.setValue(income);
    }

    /**
    * Setter for the pin
    * @author Jason Gurtz-Cayls
    * @param pin the user-set pin code
    */
    public void setPIN(String pin) {
        this.pin = pin;
    }

    /**
    * Getter for the budget date
    * @author Jason Gurtz-Cayla
    * @return Date when budget period starts
    */
    public ZonedDateTime getBudgetDate() {
        return this.budgetDate;
    }

    /**
    * Getter for the monthly income
    * @author Jason Gurtz-Cayla
    * @return monthly income
    */
    public String getMonthlyIncome() {
        return this.monthlyIncome.toString(); //we're rich!!
    }

    /**
    * Getter for the users pin
    * @author Jason Gurtz-Cayla
    * @return the user pin
    */
    public String getPIN() {
        return this.pin;
    }

    /**
    * Setter for monthly income
    * @author Jason Gurtz-Cayls
    * @param cat the category name
    * @param pct the budget percentage
    */
    public void addCategory(String cat, int pct) {
        king.addSubCategory(cat, pct);
    }

    // name, address, phone, email, category, subCategory
    /**
    * Method to add a new contact, setting all parameters
    * @author Jason Gurtz-Cayls
    * @param n The contact name
    * @param a The contact street address
    * @param p The contact phone
    * @param e The contact email
    * @param c The contact category
    * @param sc The contact sub-category
    */
    public void addContact(String n, String a, String p, String e, String c, String sc) {
        this.addressBook.add(new Contact(n, a, p, e, c, sc));
    }

    /**
    * Method to add a new contact with just a name
    * @author Jason Gurtz-Cayls
    * @param n The contact name
    */
    public void addContact(String n) {
        this.addContact(n, "", "", "", "", "");
    }

    /*
    * Get all fields from expense tab that the user entered.
    * @author Jason Gurtz-Cayla
    * @param amt Amount of expense
    * @param dt Date and time of expense, with time zone
    * @param con contact paid, the payee
    * @param cat Category of expense
    * @param subCat Sub-category of expense
    * @param memo Memo field for free-text entry
    */
    public void addExpense(Double amt, ZonedDateTime dt, String con, String cat, String subCat, String memo) {
    }

    // name, address, phone, email, category, subCategory
    /**
    * Method to find a contact with a name
    * @author Jason Gurtz-Cayls
    * @param n The contact name
    * @return a found Contact opbject
    * @exception Exception generic exception with message indicating contact not found
    */
    public Contact findContact(String n) throws Exception {

        if (n.equals("Starbucks")) {
            return new Contact("Starbucks", "123 Anystreet, Anytown, CA 94085", "900-555-1212", "coffee@startbucks.com", "Food", "Coffee");
        }
        else {
            throw new Exception("Contact not found!");
        }
    }
}
