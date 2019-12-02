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
 * Saving Cents GUI 
 * has welcome banner 
 * @author Saidel Hernandez 
 * 
 */

public class SavingCentsGUI {
   public static void main(String[] args) {
      window();
   }

   private static void window() {    
      JFrame frame = new JFrame("Welcome to Saving Cents");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      Banner(frame);
      frame.setSize(647, 400);      
      frame.setLocationRelativeTo(null);  
      frame.setVisible(true);
   }

   private static void Banner (JFrame frame){
      //Create a border
      Border b = BorderFactory.createLineBorder(Color.green); // set border color to green
      JPanel panel = new JPanel();
      LayoutManager l = new FlowLayout();  
      panel.setLayout(l);       
      JPanel panel2 = new JPanel();
      String spaces = "                   ";
      panel2.add(new JLabel(spaces + "Welcome to Saving Cents" + spaces));  
      panel2.setBorder(b);
      panel.add(panel2);
      frame.getContentPane().add(panel, BorderLayout.CENTER);    
   }
}