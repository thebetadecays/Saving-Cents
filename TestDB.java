package com.thebetadecays;
//package com.company;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 * Dashboard section of the tabbedPane
 * It has 2 buttons "add Expense" & "Settings"
 * it also displays a banner which displays Saving Cents
 * @author Saidel Hernandez
 */
class TestDB extends JFrame {

    // JFrame
    static JFrame f;

    // JButton
    static JButton banner,d, d2;

    // label to display text
    //static JLabel l;

    /**
     *  Main function
     *  populates banner and buttons
     * @author Saidel Hernandez
     * @param args CLI arguments
     */

    public static void main(String[] args)
    {
        // create a new frame to store button
        f = new JFrame("Dash Test");

        // create a label to display text
        // l = new JLabel("panel label");
        Border b = BorderFactory.createLineBorder(Color.green); // set border color to green
        JPanel um = new JPanel();
        LayoutManager l = new FlowLayout();
        um.setLayout(l);
        JPanel um2 = new JPanel();
        String spaces = "                   ";
        um2.add(new JLabel(spaces + "Welcome to Saving Cents" + spaces));
        um2.setBorder(b);
        um.add(um2);
        f.getContentPane().add(um, BorderLayout.CENTER);

        // create a new buttons
        banner= new JButton("Welcome to Saving Cents");
        d = new JButton("Add Expense");

        d2 = new JButton("Settings");

        // create a panel to add buttons
        JPanel dash = new JPanel();
        //JPanel um = new JPanel();

        // add buttons and textfield to panel
        dash.add(d);
        dash.add (Box.createHorizontalGlue());
        dash.add(d2);

        //banner
        //um.add();
        // add panel to frame
        f.add(dash, BorderLayout.SOUTH);
        f.add (um, BorderLayout.NORTH);

        // set the size of frame
        f.setSize(647, 400);

        f.show();
    }
}