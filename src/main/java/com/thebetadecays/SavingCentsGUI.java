package com.thebetadecays;

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
    * @author Saidel Hernandez, Jason Gurtz-Cayla
    */
    public SavingCentsGUI() {
        //start Jason
        setTitle("Welcome to Saving Cents");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(3, 1));

        bannerPanel = new Banner();
        tpPanel = new TabbedPane();
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
