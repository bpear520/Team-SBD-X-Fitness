package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class inputDailyRecord implements ActionListener {

    private static JFrame frame;
    private static JLabel title;
    private static JLabel calorieLabel;
    private static JTextField userCalories;
    private static JLabel workoutLabel;
    private static JCheckBox workedOut;
    private static String[] sleepQuality = {"Piss Poor","Okay","Great"};
    private static JLabel sleepLabel;
    private static JComboBox sleepType;
    private static JButton submitButton;

    inputDailyRecord() {

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

        title = new JLabel("DAILY RECORD");
        title.setBounds(100,0,200,50);
        title.setFont(new Font(null,Font.PLAIN,25));
        panel.add(title);


        // Creating JLabel
        calorieLabel = new JLabel("Calories Consumed:");
        calorieLabel.setBounds(10,60,120,25);
        panel.add(calorieLabel);

        userCalories = new JTextField(20);
        userCalories.setBounds(150,60,85,25); //20
        panel.add(userCalories);

        workoutLabel = new JLabel("Did you workout?");
        workoutLabel.setBounds(10,90,120,25);
        panel.add(workoutLabel);

        workedOut = new JCheckBox();
        workedOut.setBounds(150, 90, 25, 25);
        panel.add(workedOut);

        sleepLabel = new JLabel("How was your sleep?");
        sleepLabel.setBounds(10,120,130,25);
        panel.add(sleepLabel);

        sleepType = new JComboBox(sleepQuality);
        sleepType.setBounds(150, 120, 65, 25);
        panel.add(sleepType);

        // Creating login button
        submitButton = new JButton("submit");
        submitButton.setBounds(10, 150, 80, 25); //80
        submitButton.addActionListener(inputDailyRecord.this);
        panel.add(submitButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == submitButton) {
            frame.dispose();
            mainMenu backToMainMenu = new mainMenu();
        }
    }
}
