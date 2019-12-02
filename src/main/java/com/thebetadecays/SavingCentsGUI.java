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
        // start Saidel
        JFrame frame = new JFrame("Welcome to Saving Cents");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //start Jason
        setLayout(new GridLayout(2, 1));

        bannerPanel = new Banner();
        tpPanel = new TabbedPane();
        add(bannerPanel);
        add(tpPanel);
        //pack();
        //end Jason
        // start Saidel
        frame.setSize(647, 400);      
        frame.setLocationRelativeTo(null);  
        frame.setVisible(true);
        // End Saidel
    }
}
