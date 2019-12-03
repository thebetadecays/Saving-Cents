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
class Banner extends JPanel {
    private JLabel bannerTxt;

    /**
    * @author Saidel Hernandez
    */
    public Banner () {
        String spaces = "                   ";
        bannerTxt = new JLabel(spaces + "Welcome to Saving Cents" + spaces);

        //Create a border
        //Border b = BorderFactory.createLineBorder(Color.green); // set border color to green
        //JPanel panel = new JPanel();
        //LayoutManager l = new FlowLayout();
        //JPanel panel = new JPanel();
        //panel.setLayout(l);
        add(bannerTxt);
        //panel.setBorder(b);
        //add(panel);
        //frame.getContentPane().add(panel, BorderLayout.CENTER);
        /*
            class WelcomePanel extends JPanel {
            private JLabel welcomeText;

            public WelcomePanel() {
                welcomeText = new JLabel("Welcome to Joe's Automotive Shop!");
                add(welcomeText);
            }
        }
        */
    }
}
