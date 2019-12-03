package com.thebetadecays;

import javax.swing.*;

/**
 * Class object that is the entry point of the Saving Cents application
 * @author skyler novak, Jason Gurtz-Cayla
 */
public class SavingCents {

    /**
     * Main function starts the login pin
     * @author Skyler Novak, Saidel Hernandez
     * @param args CLI arguments
     */
    public static void main(String[] args) {
		try {
            Login frame=new Login();
            frame.setSize(300,100);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        catch(Exception j) {
            JOptionPane.showMessageDialog(null, j.getMessage());
        }
    }
}
