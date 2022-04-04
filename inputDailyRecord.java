import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;


public class inputDailyRecord extends Display implements ActionListener {

    Controller controller = Controller.getInstance();

    private static JFrame frame;
    private static JPanel panel;

    private static JLabel statusLabel;

    private static JTextField userCalories;
    private static JTextField userWeight;
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

        label = new JLabel("Calories consumed:");
        label.setBounds(10, 60, 150, 25);
        panel.add(label);

        label = new JLabel("Current weight:");
        label.setBounds(10, 90, 150, 25);
        panel.add(label);

        label = new JLabel("Did you workout?");
        label.setBounds(10, 120, 150, 25);
        panel.add(label);

        label = new JLabel("How was your sleep?");
        label.setBounds(10, 150, 150, 25);
        panel.add(label);

        //Creating user fields
        userCalories = new JTextField(20);
        userCalories.setBounds(180, 60, 85, 25); //20
        panel.add(userCalories);

        userWeight = new JTextField(20);
        userWeight.setBounds(180, 90, 85, 25); //20
        panel.add(userWeight);

        workedOut = new JCheckBox();
        workedOut.setBounds(180, 120, 25, 25);
        panel.add(workedOut);

        sleepType = new JComboBox(sleepQuality);
        sleepType.setBounds(180, 150, 65, 25);
        panel.add(sleepType);

        // Creating login button
        submitButton = new JButton("submit");
        submitButton.setBounds(25, 180, 125, 25); //80
        submitButton.addActionListener(inputDailyRecord.this);
        panel.add(submitButton);

        // Creating back button
        backToMainButton = new JButton("Back to main menu");
        backToMainButton.setBounds(210, 180, 150, 25);
        backToMainButton.addActionListener(inputDailyRecord.this);
        panel.add(backToMainButton);

        // Creating space for status message
        statusLabel = new JLabel("");
        statusLabel.setBounds(10, 210, 150, 25);
        panel.add(statusLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submitButton) {
            try {
                Date thisDate = new Date();
                SimpleDateFormat dateForm = new SimpleDateFormat("MM/dd/Y");
                String date = dateForm.format(thisDate);

                int calories = Integer.parseInt(userCalories.getText());
                boolean wrkedOut = workedOut.isSelected();

                String sleepQual = sleepQuality[sleepType.getSelectedIndex()];

                DailyFitnessRecord newRec = new DailyFitnessRecord(date, sleepQual, calories, wrkedOut);

                controller.getCurrentUser().getFitnessRecords().add(newRec);
                controller.getCurrentUser().getAchievements().updateAchievements();
                controller.writeToFile();

                frame.dispose();
                displayMainMenu();
            } catch (Exception a) {
                statusLabel.setText("*Please fill in all fields.");
            }
        }

        if (e.getSource() == backToMainButton) {
            frame.dispose();
            displayMainMenu();
        }
    }
}
