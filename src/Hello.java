import java.awt.*;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;

public class Hello {
    public static void main(String[] args) {
        JFrame frame = new JFrame("OMG this is going smthin");
        // frame.setLayout(GridLayout);
        JMenuBar menuebar = new JMenuBar();
        frame.setJMenuBar(menuebar);
        JLabel label = new JLabel("text");
        label.setText("This should be there???");
        frame.add(label, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

    }
}
