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
 * JPanel component that creates the Saving Cents banner at the top of the Frame
 * @author Saidel Hernandez, Skyler Novak
*/
class Banner extends JPanel {
    // Saidel H.
    private JLabel bannerTxt;

    // Skyler N.
    private JLabel bannerLine1;
    private JLabel bannerLine2;

    /**
     * Default Constructor
     * @author Saidel Hernandez, Skyler Novak
    */
    public Banner () {

        // Saidel H.
        String spaces = "     "; // 19 spaces
        bannerTxt = new JLabel(spaces + "Welcome to Saving Cents" + spaces);
        // Skyler N.
        bannerLine1 = new JLabel(spaces);
        bannerLine2 = new JLabel(spaces);

        // Saidel H.
        Border b = BorderFactory.createLineBorder(Color.green, 9); // set border color to green

        add(bannerLine1);   // Skyler N.
        add(bannerTxt);     // Saidel H.
        add(bannerLine2);   // Skyler N.
        setBorder(b);       // Saidel H.

    }
}
