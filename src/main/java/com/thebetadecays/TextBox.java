import javax.swing.GroupLayout;
import javax.swing.JComponent;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Dimension;
import java.awt.EventQueue;

/**
 * TextBox GUI 
 * simple text Area named "Memo" 
 * allows user to input memos when needed
 *
 * @author Saidel Hernandez 
 * 
 */

public class TextBox extends JFrame {

    public TextBox() {

        testText();
    }

    private void testText() {

        var k = new JTextArea(); // constructor of TextBox component
        var l = new JScrollPane(k);  // makes text scrollable
        k.setBackground(Color.yellow);

        Layout(l);

        setTitle("Memo");
        setSize(new Dimension(350, 300));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
       
    }

    private void Layout(JComponent... arg) {

        var a = getContentPane();
        var b = new GroupLayout(a);
        a.setLayout(b);

        b.setAutoCreateContainerGaps(true);
        b.setAutoCreateGaps(true);

        b.setHorizontalGroup(b.createParallelGroup()
                .addComponent(arg[0])

        );

        b.setVerticalGroup(b.createSequentialGroup()
                .addComponent(arg[0])
        );

        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var notes = new TextBox();
            notes.setVisible(true);
        });
    }
}
