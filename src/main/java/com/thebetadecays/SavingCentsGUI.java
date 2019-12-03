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
    * @author Saidel Hernandez, Jason Gurtz-Cayla
    */
    public SavingCentsGUI(Model SC_Model) {
        //start Jason
        setTitle("Welcome to Saving Cents");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //setLayout(new GridLayout(2, 1));
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        //setLayout(new GridBagLayout());

        bannerPanel = new Banner();
        bannerPanel.setLayout(new BoxLayout(bannerPanel, BoxLayout.Y_AXIS));
        tpPanel = new TabbedPane(SC_Model);
        tpPanel.setLayout(new BoxLayout(tpPanel, BoxLayout.Y_AXIS));
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
