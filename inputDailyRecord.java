import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class inputDailyRecord extends Display implements ActionListener {

    Controller controller = Controller.getInstance();

    private static JFrame frame;
    private static JPanel panel;

    private static JLabel statusLabel;

    private static JTextField userCalories;

    private static JCheckBox workedOut;

    private static String[] sleepQuality = {"Poor", "Okay", "Great"};
    private static JComboBox sleepType;

    private static JButton submitButton;
    private static JButton backToMainButton;


    inputDailyRecord() {
        frame = new JFrame();

        frame.setSize(420, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);


        panel = new JPanel();
        // adding panel to frame
        frame.add(panel);

        placeComponents(panel);

        frame.setVisible(true);
    }


    private void placeComponents(JPanel panel) {
        JLabel label;
        panel.setLayout(null);
        Color color = new Color(103, 146, 103);
        panel.setBackground(color);

        //Placing labels
        label = new JLabel("DAILY RECORD");
        label.setBounds(100, 0, 200, 50);
        label.setFont(new Font(null, Font.PLAIN, 25));
        panel.add(label);

        label = new JLabel("Calories Consumed:");
        label.setBounds(10, 60, 120, 25);
        panel.add(label);

        label = new JLabel("Did you workout?");
        label.setBounds(10, 90, 120, 25);
        panel.add(label);

        label = new JLabel("How was your sleep?");
        label.setBounds(10, 120, 130, 25);
        panel.add(label);

        //Creating user fields
        userCalories = new JTextField(20);
        userCalories.setBounds(150, 60, 85, 25); //20
        panel.add(userCalories);

        workedOut = new JCheckBox();
        workedOut.setBounds(150, 90, 25, 25);
        panel.add(workedOut);

        sleepType = new JComboBox(sleepQuality);
        sleepType.setBounds(150, 120, 65, 25);
        panel.add(sleepType);

        // Creating login button
        submitButton = new JButton("submit");
        submitButton.setBounds(25, 150, 125, 25); //80
        submitButton.addActionListener(inputDailyRecord.this);
        panel.add(submitButton);

        // Creating back button
        backToMainButton = new JButton("Back to main menu");
        backToMainButton.setBounds(210, 150, 150, 25);
        backToMainButton.addActionListener(inputDailyRecord.this);
        panel.add(backToMainButton);

        // Creating space for status message
        statusLabel = new JLabel("");
        statusLabel.setBounds(10, 180, 120, 25);
        panel.add(statusLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submitButton) {
            //try {
                Date thisDate = new Date();
                SimpleDateFormat dateForm = new SimpleDateFormat("MM/dd/Y");
                String date = dateForm.format(thisDate);

                int calories = Integer.parseInt(userCalories.getText());
                boolean wrkedOut = workedOut.isSelected();

                String sleepQual = sleepQuality[sleepType.getSelectedIndex()];

                DailyFitnessRecord newRec = new DailyFitnessRecord(date, sleepQual, calories, wrkedOut);

                controller.getCurrentUser().getFitnessRecords().add(newRec);
                controller.writeToFile();

                frame.dispose();
                displayMainMenu();
            //} catch (Exception a) {
               // statusLabel.setText("*Please fill in Calories");
            //}
        }

        if (e.getSource() == backToMainButton) {
            frame.dispose();
            displayMainMenu();
        }
    }
}
