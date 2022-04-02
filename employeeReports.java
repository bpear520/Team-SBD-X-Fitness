import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class employeeReports implements ActionListener {

    private static JFrame frame;
    private static JButton backToMainButton;
    private static JButton prevEmpButton;
    private static JButton nextEmpButton;

    employeeReports(){
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

        label = new JLabel("EMPLOYEE RECORDS");
        label.setBounds(65, 0, 275, 50);
        label.setFont(new Font(null, Font.PLAIN, 25));
        panel.add(label);

        label = new JLabel("Employee Name:");
        label.setBounds(10, 60, 175, 25);
        panel.add(label);

        label = new JLabel("Average Calories Consumed:");
        label.setBounds(10, 100, 175, 25);
        panel.add(label);

        label = new JLabel("How many times worked out:");
        label.setBounds(10, 140, 175, 25);
        panel.add(label);

        label = new JLabel("Average Sleep Quality:");
        label.setBounds(10, 180, 175, 25);
        panel.add(label);


        // Creating input button
        prevEmpButton = new JButton("Previous Employee");
        prevEmpButton.setBounds(10, 220, 150, 25);
        prevEmpButton.addActionListener(employeeReports.this);
        panel.add(prevEmpButton);

        // Creating input button
        nextEmpButton = new JButton("Next Employee");
        nextEmpButton.setBounds(210, 220, 150, 25);
        nextEmpButton.addActionListener(employeeReports.this);
        panel.add(nextEmpButton);

        // Creating input button
        backToMainButton = new JButton("Back to main menu");
        backToMainButton.setBounds(110, 260, 150, 25);
        backToMainButton.addActionListener(employeeReports.this);
        panel.add(backToMainButton);

    }

        @Override
    public void actionPerformed(ActionEvent e) {

            if (e.getSource() == backToMainButton) {
                frame.dispose();
                mainMenu backToMainMenu = new mainMenu();
            }
    }
}