package com.thebetadecays;

import com.thebetadecays.SC_Model.Model;

import java.awt.*;
import javax.swing.*;

/**
 * Delegate class of SavingCents representing the View and Controller of classic MVC pattern 
 * @author Saidel Hernandez, Jason Gurtz-Cayla
 */
public class SavingCentsGUI extends JFrame {
    private Banner bannerPanel;
    private TabbedPane tpPanel;

    /**
    * @author Saidel Hernandez, Jason Gurtz-Cayla, Skyler N.
    */
    public SavingCentsGUI(Model SC_Model) {
        //start Jason
        setTitle("Welcome to Saving Cents");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set layout manager for Frame
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS)); // Skyler N.

        bannerPanel = new Banner();
        bannerPanel.setLayout(new BoxLayout(bannerPanel, BoxLayout.Y_AXIS)); // Skyler N.
        tpPanel = new TabbedPane(SC_Model);
        tpPanel.setLayout(new BoxLayout(tpPanel, BoxLayout.Y_AXIS));    // Skyler N.
        add(bannerPanel);
        add(tpPanel);
        pack();
        //end Jason
        // start Saidel
        setSize(647, 400);
        setLocationRelativeTo(null);  
        setVisible(true);
        // End Saidel
    }
}
