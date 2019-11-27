package com.thebetadecays;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
 
/**
 * TabbedPane is the main panel that runs the GUI for Saving Cents
 * It will have 4 tabs, Dashboard, Expense, Contacts, and Reports
 * @author Skyler Novak
 */
public class TabbedPane extends JFrame //{

    // Panels
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
    private JLabel testLabel = new JLabel();

    // Text Fields
    private JTextField testTextField = new JTextField(25);

    // Buttons
    private JButton testButton = new JButton("Help!:");


    // Window params
    private final int WINDOW_WIDTH = 647;
    private final int WINDOW_HEIGHT = 400;
    
     
    /**
     * Constructor
     */
    public TabbedPane() {
         
        // initialize Pane values
        setTitle("Saving Cents");
        pack(); // Sets window large enough for all elements to appear
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);  // sets size of window (ratio is golden rectangle)
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

        // Add labels to the correct panel
        jp1.add(label1);
        jp2.add(label2);
        jp3.add(label3);
        jp4.add(label4);

        // Test components      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        testLabel.setText("THIS IS A TEST 1...2...3...");
        jp2.add(testLabel);
        jp2.add(testTextField);
        jp2.add(testButton);
        
        // Add panes to tabs
        jtp.addTab("Dashboard", jp1);
        jtp.addTab("Expense", jp2);
        jtp.addTab("Contacts", jp3);
        jtp.addTab("Reports", jp4);

    } // buildPanel()

         
    public static void main(String[] args) {
         
        TabbedPane tp = new TabbedPane();
    
        tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tp.pack();  // Sets window large enough for all elements to appear
        tp.setSize(647, 400);   // sets size of window (ratio is golden rectangle)
        tp.setVisible(true);
    } // Main
} // TabbedPane
