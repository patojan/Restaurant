package restaurant.ui.main_window;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public JPanel panel1;
    public JPanel panel2;
    public JPanel panel3;

    public MainWindow() {
        this.setTitle("Restaurant");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBounds(1,1,1920,1080);
        this.setVisible(true);

        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        this.setLayout(new GridLayout(1,3));

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);

        panel3.setLayout(new FlowLayout());

    }
}
