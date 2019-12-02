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
    }

    public void actionPerformed(ActionEvent e)
    {
        String value = text.getText();
        String value1 = text1.getText();

        if (value.equals("cs") && value1.equals("0000"))
        {
            JOptionPane.showMessageDialog(this,"correct");
        }
        else
        {
            System.out.println("enter the valid username and password");
            JOptionPane.showMessageDialog(this,"Incorrect login or password",
                "Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}

class LoginPin
{
    public static void main(String arg[])
    {
        try
        {
            Login frame=new Login();
            frame.setSize(300,100);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        catch(Exception j)
        {
            JOptionPane.showMessageDialog(null, j.getMessage());
        }
    }
}
