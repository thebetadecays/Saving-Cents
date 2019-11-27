package com.thebetadecays;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
 
/**
 * TabbedPane is the main panel that runs the GUI for Saving Cents
 * It will have 4 tabs, Dashboard, Expense, Contacts, and Reports
 * @author Skyler Novak
 */
public class TabbedPane extends JFrame {
     
    public TabbedPane() {
         
        // initialize Pane values
        setTitle("Saving Cents");
        JTabbedPane jtp = new JTabbedPane();
        getContentPane().add(jtp);

        // initialize new panes that will be the tabs
        JPanel jp1 = new JPanel(); // Dashboard
        JPanel jp2 = new JPanel(); // Expenses
        JPanel jp3 = new JPanel(); // Contacts
        JPanel jp4 = new JPanel(); // Reports

        // Create labels for each tab/Pane
        JLabel label1 = new JLabel();
        label1.setText("You are in area of Tab1");
        JLabel label2 = new JLabel();
        label2.setText("You are in area of Tab2");
        JLabel label3 = new JLabel();
        label3.setText("You are in area of Tab3");
        JLabel label4 = new JLabel();
        label4.setText("You are in area of Tab4");

        // Add labels to the correct pant
        jp1.add(label1);
        jp2.add(label2);
        jp3.add(label3);
        jp4.add(label4);
        
        // Add panes to tabs
        jtp.addTab("Dashboard", jp1);
        jtp.addTab("Expense", jp2);
        jtp.addTab("Contacts", jp3);
        jtp.addTab("Reports", jp4);

    }

         
    public static void main(String[] args) {
         
        TabbedPane tp = new TabbedPane();
        tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tp.pack();  // Sets window large enough for all elements to appear
        tp.setSize(647, 400);   // sets size of window (ratio is golden rectangle)
        tp.setVisible(true);
    }
}
