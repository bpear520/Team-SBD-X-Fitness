import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class inputDailyRecord implements ActionListener {

    private static JFrame frame;

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


        JPanel panel = new JPanel();
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

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submitButton) {
            frame.dispose();
            mainMenu backToMainMenu = new mainMenu();
        }

        if (e.getSource() == backToMainButton) {
            frame.dispose();
            mainMenu backToMainMenu = new mainMenu();
        }
    }
}
