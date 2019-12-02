package com.thebetadecays;

import com.thebetadecays.SC_Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * pin login GUI 
 * allows user to enter name and pin 
 * if pin and name match will take user
 * to main Dash if incorrect will prompt
 * error message
 *
 * @author Saidel Hernandez 
 * 
 */
 
class Login extends JFrame implements ActionListener
{
    JButton Submit;
    JPanel panel;
    JLabel label,label1;
    final JTextField  text,text1;
 

    //TODO: make for just a PIN and use getPIN() from the model
    Login()
    {
        label = new JLabel();
        label.setText("Name:");
        text = new JTextField(20);

        label1 = new JLabel();
        label1.setText("Pin:");
        text1 = new JPasswordField(20);

        Submit = new JButton("Submit");

        panel = new JPanel(new GridLayout(3,1));
        panel.add(label);
        panel.add(text);
        panel.add(label1);
        panel.add(text1);
        panel.add(Submit);
        add(panel);
        Submit.addActionListener(this);
        setTitle("Saving Cents");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
    * @author Saidel Hernandez, Jason Gurtz-Cayla
    */
    public void actionPerformed(ActionEvent e)
    {
        String value = text.getText();
        String value1 = text1.getText();

        if (value.equals("cs") && value1.equals("0000"))
        {
            //start Jason
            SavingCentsGUI scg = new SavingCentsGUI();
            this.dispose();
            // end Jason
        }
        else
        {
            System.out.println("enter the valid username and password");
            JOptionPane.showMessageDialog(this,"Incorrect login or password",
                "Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
