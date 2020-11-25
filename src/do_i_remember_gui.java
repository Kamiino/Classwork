import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class do_i_remember_gui implements ActionListener {

    int count;

    JLabel label = new JLabel("Hello, here is a button", SwingConstants.CENTER);
    JLabel counter = new JLabel("Number of Clicks: " + count, SwingConstants.CENTER);


    public do_i_remember_gui() {


        JButton button = new JButton("I'm a button");
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(60, 40));
        button.setForeground(Color.white);
        button.setBackground(Color.darkGray);
        button.setOpaque(true);
        button.setBorderPainted(false);

        JButton reset = new JButton("Reset");
        reset.addActionListener(this);
        reset.setForeground(Color.white);
        reset.setBackground(Color.darkGray);
        reset.setOpaque(true);
        reset.setBorderPainted(false);

        label.setForeground(Color.white);
        counter.setForeground(Color.white);

        JFrame frame = new JFrame();

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(150,150,50,150));
        panel.setLayout(new GridLayout(0,1));
        panel.setBackground(Color.black);

        panel.add(label);
        panel.add(counter);
        panel.add(button);
        panel.add(reset);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI Test");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new do_i_remember_gui();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("I'm a button")) {
            count++;
            counter.setText("Number of Clicks: " + count);
            if (count == 1) {
                label.setText("Click!");
            } if (count == 2) {
                label.setText("You already clicked me");
            } else if (count > 2){
                label.setText("Stop clicking me!");
            }
        } else if(action.equals("Reset")) {
            count = 0;
            label.setText("I'm a button!");
            counter.setText("Number of Clicks: " + count);
        }

    }

}
