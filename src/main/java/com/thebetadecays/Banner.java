package com.thebetadecays;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
* @author Saidel Hernandez
*/
public class Banner extends JPanel {

    /**
    * @author Saidel Hernandez
    */
    public Banner () {
        //Create a border
        Border b = BorderFactory.createLineBorder(Color.green); // set border color to green
        JPanel panel = new JPanel();
        LayoutManager l = new FlowLayout();
        panel.setLayout(l);
        JPanel panel2 = new JPanel();
        String spaces = "                   ";
        panel2.add(new JLabel(spaces + "Welcome to Saving Cents" + spaces));
        panel2.setBorder(b);
        panel.add(panel2);
        //frame.getContentPane().add(panel, BorderLayout.CENTER);
    }
}
