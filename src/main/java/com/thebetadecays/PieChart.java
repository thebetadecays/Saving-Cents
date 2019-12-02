package com.thebetadecays;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Sample Pie Chart  
 * will show how much of budget is being used
 * 
 * @author Saidel Hernandez 
 */

class Part {
   double value;
   Color color;
   
   public Part(double value, Color color) {
      this.value = value;
      this.color = color;
   }
}
class PieComp extends JComponent {
   Part[] slices = { 
      new Part(5, Color.yellow),
      new Part(40, Color.blue),
      new Part(25, Color.pink),
      new Part(30, Color.red)
   }; 
   PieComp() {
   }
   public void paint(Graphics g)
   {
      drawPieChart((Graphics2D) g,
      getBounds(), slices);
   } 
   void drawPieChart(Graphics2D g, Rectangle area, Part[] slices) {
      double total = 0.0D;
      for (int i = 0; i < slices.length; i++) {
         total += slices[i].value;
      } 
      double current = 0.0D;
      int start = 0;
      for (int i = 0; i < slices.length; i++) {
         start = (int) (current * 360 / total);
         int arcAngle = (int) (slices[i].value * 360 / total);
         
         g.setColor(slices[i].color);
         g.fillArc(area.x, area.y, area.width, area.height, start, arcAngle);
         current += slices[i].value;
      } 
   }
}
public class PieChart {
   public static void main(String[] argv) {
      JFrame frame = new JFrame();
      frame.getContentPane().add(new PieComp());
      frame.setSize(647, 400);
      frame.setVisible(true);
   }
}