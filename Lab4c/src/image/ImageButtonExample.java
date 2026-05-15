package image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageButtonExample extends JFrame implements ActionListener {

    JButton clockBtn, hourglassBtn;

    public ImageButtonExample() {

        // Frame settings
        setTitle("Button Image Example");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon clockIcon = new ImageIcon("clock.png");
        ImageIcon hourglassIcon = new ImageIcon("hourglass.png");

        clockBtn = new JButton(clockIcon);
        hourglassBtn = new JButton(hourglassIcon);

        // Add Action Listener
        clockBtn.addActionListener(this);
        hourglassBtn.addActionListener(this);

        // Add buttons to frame
        add(clockBtn);
        add(hourglassBtn);

        setVisible(true);
    }

    // Event Handling
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clockBtn) {
            JOptionPane.showMessageDialog(this, "Digital Clock is pressed");
        } else if (e.getSource() == hourglassBtn) {
            JOptionPane.showMessageDialog(this, "Hour Glass is pressed");
        }
    }

    public static void main(String[] args) {
        new ImageButtonExample();
    }
}