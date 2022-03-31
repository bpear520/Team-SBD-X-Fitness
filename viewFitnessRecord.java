package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class viewFitnessRecord implements ActionListener {

    private static JFrame frame;
    private static JLabel title;

    private static JLabel caloriesLabel;
    private static JLabel sleepQualityLabel;
    private static JLabel workedOutLabel;
    private static JLabel caloriesOutput;
    private static JLabel sleepQualityOutput;
    private static JLabel workedOutOutput;

    private static JButton backToMainButton;
    private static JButton previousWeekButton;
    private static JButton nextWeekButton;

    viewFitnessRecord() {

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

        title = new JLabel("FITNESS RECORD");
        title.setBounds(100,0,250,50);
        title.setFont(new Font(null,Font.PLAIN,25));
        panel.add(title);

        // Creating JLabel
        caloriesLabel = new JLabel("Calories:");
        caloriesLabel.setBounds(10,60,120,25);
        panel.add(caloriesLabel);

        // Creating JLabel
        caloriesOutput = new JLabel("User Calories Go Here");
        caloriesOutput.setBounds(110,60,120,25);
        panel.add(caloriesOutput);

        // Creating JLabel
        sleepQualityLabel = new JLabel("Sleep Quality:");
        sleepQualityLabel.setBounds(10,90,120,25);
        panel.add(sleepQualityLabel);

        // Creating JLabel
        sleepQualityOutput = new JLabel("User Sleep Go Here");
        sleepQualityOutput.setBounds(110,90,120,25);
        panel.add(sleepQualityOutput);

        // Creating JLabel
        workedOutLabel = new JLabel("Worked Out:");
        workedOutLabel.setBounds(10,120,120,25);
        panel.add(workedOutLabel);

        // Creating JLabel
        workedOutOutput = new JLabel("User workedout Go Here");
        workedOutOutput.setBounds(110,120,120,25);
        panel.add(workedOutOutput);

        // Creating input button
        previousWeekButton = new JButton("Previous Week");
        previousWeekButton.setBounds(10, 160, 150, 25);
        previousWeekButton.addActionListener(viewFitnessRecord.this);
        panel.add(previousWeekButton);

        // Creating input button
        nextWeekButton = new JButton("Next Week");
        nextWeekButton.setBounds(210, 160, 150, 25);
        nextWeekButton.addActionListener(viewFitnessRecord.this);
        panel.add(nextWeekButton);

        // Creating input button
        backToMainButton = new JButton("Back to main menu");
        backToMainButton.setBounds(110, 210, 150, 25);
        backToMainButton.addActionListener(viewFitnessRecord.this);
        panel.add(backToMainButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == backToMainButton) {
            frame.dispose();
            mainMenu backToMainMenu = new mainMenu();
        }
    }
}
