import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class employeeReports extends Display implements ActionListener {

    private static JFrame frame;

    private JLabel employeeOutput;
    private JLabel caloriesOutput;
    private JLabel sleepQualityOutput;
    private JLabel workoutOutput;

    private static JButton backToMainButton;
    private static JButton prevEmpButton;
    private static JButton nextEmpButton;

    Controller controller = Controller.getInstance();
    private int employeeIndex = controller.getNumberOfEmployees() - 1;

    employeeReports() {
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


        // Creating employee output labels
        employeeOutput = new JLabel(controller.getEmployeeList().get(employeeIndex).getPersonalrecods().getFirstName());
        employeeOutput.setBounds(210, 60, 175, 25);
        panel.add(employeeOutput);

        caloriesOutput = new JLabel(String.valueOf(controller.getEmployeeList().get(employeeIndex).getAverageCalories()));
        caloriesOutput.setBounds(210, 100, 175, 25);
        panel.add(caloriesOutput);

        workoutOutput = new JLabel(String.valueOf(controller.getEmployeeList().get(employeeIndex).getNumTimesWorkedOut()));
        workoutOutput.setBounds(210, 140, 175, 25);
        panel.add(workoutOutput);

        sleepQualityOutput = new JLabel(controller.getEmployeeList().get(employeeIndex).getAverageSleepQuality());
        sleepQualityOutput.setBounds(210, 180, 175, 25);
        panel.add(sleepQualityOutput);

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

    public boolean hasEmployees() {
        if(controller.employeeList == null)
            return false;
        else
            return true;
    }

    public void updateOutputs() {
        employeeOutput.setText(controller.getEmployeeList().get(employeeIndex).getPersonalrecods().getFirstName());
        caloriesOutput.setText(String.valueOf(controller.getEmployeeList().get(employeeIndex).getAverageCalories()));
        workoutOutput.setText(String.valueOf(controller.getEmployeeList().get(employeeIndex).getNumTimesWorkedOut()));
        sleepQualityOutput.setText(controller.getEmployeeList().get(employeeIndex).getAverageSleepQuality());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == prevEmpButton) {
            if(employeeIndex > 0) {
                employeeIndex--;
            }
            updateOutputs();
        }

        if(e.getSource() == nextEmpButton) {
            if(employeeIndex < controller.getNumberOfEmployees() - 1) {
                employeeIndex++;
            }
            updateOutputs();
        }

        if (e.getSource() == backToMainButton) {
            frame.dispose();
            displayMainMenu();
        }
    }
}
