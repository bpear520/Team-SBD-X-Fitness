package com.company;

import com.company.inputDailyRecord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainMenu implements ActionListener {

    private static JFrame frame;
    private static JLabel logo;
    private static JButton inputButton;
    private static JButton viewButton;
    private static JLabel userLabel;

    mainMenu() {

        frame = new JFrame();

        frame.setSize(420, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        // adding panel to frame
        frame.add(panel);

        placeComponents(panel);

        frame.setVisible(true);

    }

    private void placeComponents(JPanel panel) {

        panel.setLayout(null);

        logo = new JLabel("X-FITNESS");
        logo.setBounds(140,0,175,50);
        logo.setFont(new Font(null,Font.PLAIN,25));
        panel.add(logo);

        // Creating input button
        inputButton = new JButton("Input daily record");
        inputButton.setBounds(125, 60, 150, 25);
        inputButton.addActionListener(mainMenu.this);
        panel.add(inputButton);


        // Creating input button
        viewButton = new JButton("View records");
        viewButton.setBounds(125, 90, 150, 25);
//        viewButton.addActionListener(new GUI());
        panel.add(viewButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == inputButton) {
            frame.dispose();
            inputDailyRecord dailyRecord = new inputDailyRecord();
        }
    }
}
