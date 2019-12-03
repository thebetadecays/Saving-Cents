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
    private JLabel bannerLine1;
    private JLabel bannerLine2;

    /**
    * @author Saidel Hernandez
    */
    public Banner () {

        String spaces = "     "; // 19 spaces
        String line = spaces;
        bannerTxt = new JLabel(spaces + "Welcome to Saving Cents" + spaces);
        bannerLine1 = new JLabel(spaces);
        bannerLine2 = new JLabel(spaces);

        Border b = BorderFactory.createLineBorder(Color.green, 9); // set border color to green

        add(bannerLine1);
        add(bannerTxt);
        add(bannerLine2);
        setBorder(b);

    }
}
