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
    Category category;
    ArrayList<Contact> addressBook;
    ArrayList<Expense> expenses;

    public Model() {
        /* need to instantiate:
        *
        * - The base "king" category object
        * 
        * - Contacts (address book)
        *
        * - Expense record
        *
        */

    }

    /* Actually, will call individual load/save methods in DB class
    private void load() {
    }

    private void save() {
    }
    */

    public void setBudgetDate(ZonedDateTime dt) {
    }

    public void setMonthlyIncome(double income) {
    }

    public void setPIN(String pin) {
    }

    public ZonedDateTime getBudgetDate() {
        // https://www.baeldung.com/java-8-date-time-intro
        // https://docs.oracle.com/javase/8/docs/api/java/time/ZonedDateTime.html
        // https://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html
        // https://docs.oracle.com/javase/8/docs/api/java/time/ZoneId.html
        return ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("PST"));
    }

    public String getMonthlyIncome() {
        return "Never enough!!!";
    }

    public String getPIN() {
        return "abc123";
    }

    public void addCategory(String cat) {
    }

    public void editCategory(String oldName, String name) {
    }

    public void removeCategory(String name) {
    }

    public void addSubCategory(String c, String sc) {
    }

    public void removeSubCategory(String c, String sc) {
    }

    // name, category, subCategory, addy, phone, email
    public void addContact(String n, String c, String sc, String a, String p, String e) {
    }

    public void addContact(String n) {
        addContact(n, "", "", "", "", "");
    }

    public void removeContact(String n) {
    }

    public void addExpense(Double amt, ZonedDateTime dt, String contact, String cat, String subCat, String memo) {
    }

    public void removeExpense(String amt, ZonedDateTime dt) {
    }
}
