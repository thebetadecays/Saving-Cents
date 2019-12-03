package com.thebetadecays;

import com.thebetadecays.SC_Model.Model;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZonedDateTime;
import javax.swing.*;
 
/**
 * TabbedPane is the main panel that controls which view is active
 * It will have 4 tabs, Dashboard, Expense, Contacts, and Reports
 * @author Skyler Novak
 */
public class TabbedPane extends JPanel {

    //TODO: get the 4 panels into separate classes and files
    //      eg. Dashboard_Pl, Expenses_Pl, ...
    //      Check SavingCentsGUI for how (minus the JFrame stuff)
    //      Panels
    private JTabbedPane jtp = new JTabbedPane();
    private JPanel jp1 = new JPanel(); // Dashboard
    private JPanel jp2 = new JPanel(); // Expenses
    private JPanel jp3 = new JPanel(); // Contacts
    private JPanel jp4 = new JPanel(); // Reports

    // Labels
    private JLabel label1 = new JLabel(); // Dashboard Label
    private JLabel label2 = new JLabel(); // Expenses Label
    private JLabel label3 = new JLabel(); // Contacts Label
    private JLabel label4 = new JLabel(); // Reports Label
    private JLabel expConName = new JLabel();
    private JLabel expAmt = new JLabel();
    private JLabel expDate = new JLabel();
    private JLabel expCatLabel = new JLabel();
    private JLabel expSubCatLabel = new JLabel();
    private JLabel expMemo = new JLabel();

    // Text Fields
    private JTextField expConTF = new JTextField(25);
    private JTextField expAmtTF = new JTextField(25);

    // Text Area
    private JTextArea expMemoTF = new JTextArea(5, 50);

    // Buttons
    private JButton expAdd = new JButton("Add");
    private JButton expEdit = new JButton("Edit");
    private JButton expDel = new JButton("Delete");

    // Combo Boxes
    private JComboBox expCategories;
    private JComboBox expSubCat;

    //TODO: Create Categories_Pl class and if there's time, make this dynamic from the Model
    // String Arrays  --  Categories/Sub-categories
    String categories[] = {"Housing", "Transportation", "Food", "Utilities", "Insurance", "Medical & Healthcare",
            "Saving & Investments", "Personal", "Entertainment", "Miscellaneous"};
     
    /**
     * Default Constructor
     * @author Skyler Novak
     */
    public TabbedPane(Model SC_Model) {

        // add JTabbedPane object to JFrame content pane
        add(jtp);

        // Create labels for each tab/Pane
        label1.setText("You are in area of Tab1 - DASHBOARD");
        label2.setText("You are in area of Tab2 - EXPENSES");
        label3.setText("You are in area of Tab3 - CONTACTS");
        label4.setText("You are in area of Tab4 - REPORTS");

        // Add labels to the correct panel -- Remove as panel is worked on
        jp1.add(label1);
        jp3.add(label3);
        jp4.add(label4);

        // add components to Expense Tab
        buildExpenseTab(SC_Model);

        // Add panes to tabs
        jtp.addTab("Dashboard", jp1);
        jtp.addTab("Expense", jp2);
        jtp.addTab("Contacts", jp3);
        jtp.addTab("Reports", jp4);

    } // Constructor

    /**
     * method to build the expense tab in the TabbedPane frame
     * populates with panels and components
     * @author Skyler Novak
     */
     //TODO: refactor into constructor of new panel class Expenses_Pl
    private void buildExpenseTab(Model SC_Model) {

        // Set layout manager for expense tab
        jp2.setLayout(new GridLayout(7, 1));

        // Panels to use for Expense Tab
        JPanel expPanel1 = new JPanel();
        JPanel expPanel2 = new JPanel();
        JPanel expPanel3 = new JPanel();
        JPanel expPanel4 = new JPanel();
        JPanel expPanel5 = new JPanel();
        JPanel expPanel6 = new JPanel();
        JPanel expPanel7 = new JPanel();

        // Combo Box for categories & item listener
        expCategories = new JComboBox(categories);
        expSubCat = new JComboBox(categories);

        // Define labels for Expense Tab
        expConName.setText("Contact Name");
        expAmt.setText("Amount");
        expDate.setText("The Date Timestamp will be recorded");
        expCatLabel.setText("Category");
        expSubCatLabel.setText("Sub-Category");
        expMemo.setText("Memo");

        // Add components to Panels
        expPanel1.add(expConName);
        expPanel1.add(expConTF);
        expPanel1.add(expCatLabel);
        expPanel1.add(expCategories);
        expPanel2.add(expAmt);
        expPanel2.add(expAmtTF);
        expPanel2.add(expSubCatLabel);
        expPanel2.add(expSubCat);
        expPanel3.add(expDate);
        expPanel4.add(expMemo);
        expPanel5.add(expMemoTF);
        expPanel7.add(expAdd);
        expPanel7.add(expEdit);
        expPanel7.add(expDel);

        // Add panels to Expense Tab
        jp2.add(expPanel1);
        jp2.add(expPanel2);
        jp2.add(expPanel3);
        jp2.add(expPanel4);
        jp2.add(expPanel5);
        jp2.add(expPanel6);
        jp2.add(expPanel7);

        // Action Listeners
        expAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                double amt = Double.parseDouble(expAmtTF.getText());
                ZonedDateTime dt = ZonedDateTime.now();
                String con = expConTF.getText();
                String cat = expCategories.toString();  // Is this correct?
                String subCat = expSubCat.toString();   // Same
                String memo = expMemoTF.getText();

                // addExpense(Double amt, ZonedDateTime dt, String contact, String cat, String subCat, String memo) {
                SC_Model.addExpense(amt, dt, con, cat, subCat, memo);


                // Debugging
                System.out.println("Debugging ExpTab Add button");
                System.out.println(amt);
                System.out.println(dt);
                System.out.println(con);
                System.out.println(cat);
                System.out.println(subCat);
                System.out.println(memo);

            } // actionPerformed()

        }); // expAdd.addActionListener

    } // buildExpenseTab()

} // TabbedPane
