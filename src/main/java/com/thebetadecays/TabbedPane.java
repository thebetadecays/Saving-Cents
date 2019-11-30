package com.thebetadecays;

import java.awt.*;
import javax.swing.*;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JTabbedPane;
 
/**
 * TabbedPane is the main panel that runs the GUI for Saving Cents
 * It will have 4 tabs, Dashboard, Expense, Contacts, and Reports
 * @author Skyler Novak
 */
public class TabbedPane extends JFrame {

    // Panels
    private JTabbedPane jtp = new JTabbedPane();
    private JPanel jp1 = new JPanel(); // Dashboard
    private JPanel jp2 = new JPanel(); // Expenses
    private JPanel jp3 = new JPanel(); // Contacts
    private JPanel jp4 = new JPanel(); // Reports

    // Add Layout Managers
    //setLayout(new BorderLayout());

    // Labels
    private JLabel label1 = new JLabel(); // Dashboard Label
    private JLabel label2 = new JLabel(); // Expenses Label
    private JLabel label3 = new JLabel(); // Contacts Label
    private JLabel label4 = new JLabel(); // Reports Label
    private JLabel expConName = new JLabel();
    private JLabel expAmt = new JLabel();
    private JLabel expDate = new JLabel();
    private JLabel expCatLabel = new JLabel();

    // Text Fields
    private JTextField testTextField1 = new JTextField(25);
    private JTextField testTextField2 = new JTextField(25);
    private JTextField testTextField3 = new JTextField(25);

    // Buttons
    private JButton expAdd = new JButton("Add");
    private JButton expEdit = new JButton("Edit");
    private JButton expDel = new JButton("Delete");

    // Combo Boxes
    private JComboBox expCategories;

    // Window params
    private final int WINDOW_WIDTH = 647;
    private final int WINDOW_HEIGHT = 400;

    // Categories / Sub categories string arrays
    String categories[] = {"Housing", "Transportation", "Food", "Utilities", "Insurance", "Medical & Healthcare",
            "Saving & Investments", "Personal", "Entertainment", "Miscellaneous"};
     
    /**
     * Constructor
     */
    public TabbedPane() {
         
        // initialize Pane values
        setTitle("Saving Cents");
        pack(); // Sets window large enough for all elements to appear
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);  // sets size of window (ratio is golden rectangle)
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Build & populate content panes
        buildPanel();

    } // Constructor

    /**
     * Create panel object, populate with components,
     * and add to content pane of JFrame object
     */
    private void buildPanel() {

        // add JTabbedPane object to JFrame content pane
        getContentPane().add(jtp);

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
        buildExpenseTab();

        // Add panes to tabs
        jtp.addTab("Dashboard", jp1);
        jtp.addTab("Expense", jp2);
        jtp.addTab("Contacts", jp3);
        jtp.addTab("Reports", jp4);

    } // buildPanel()

    private void buildExpenseTab() {
        jp2.setLayout(new GridLayout(7, 1));

        JPanel expPanel1 = new JPanel();
        JPanel expPanel2 = new JPanel();
        JPanel expPanel3 = new JPanel();
        JPanel expPanel4 = new JPanel();
        JPanel expPanel5 = new JPanel();
        JPanel expPanel6 = new JPanel();

        expCategories = new JComboBox(categories);

        expConName.setText("Contact Name");
        expAmt.setText("Amount");
        expDate.setText("Date");
        expCatLabel.setText("Category");

        expPanel1.add(expConName);
        expPanel1.add(testTextField1);
        expPanel2.add(expAmt);
        expPanel2.add(testTextField2);
        expPanel3.add(expDate);
        expPanel3.add(testTextField3);
        expPanel4.add(expCatLabel);
        expPanel4.add(expCategories);
        expPanel6.add(expAdd);
        expPanel6.add(expEdit);
        expPanel6.add(expDel);

        jp2.add(expPanel1);
        jp2.add(expPanel2);
        jp2.add(expPanel3);
        jp2.add(expPanel4);
        jp2.add(expPanel5);
        jp2.add(expPanel6);
    }
         
    public static void main(String[] args) {
         
        TabbedPane tp = new TabbedPane();

    } // Main
} // TabbedPane
