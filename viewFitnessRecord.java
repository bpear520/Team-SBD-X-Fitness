import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class viewFitnessRecord extends Display implements ActionListener {

    private static JFrame frame;
    private static JButton backToMainButton;
    private static JButton previousWeekButton;
    private static JButton nextWeekButton;
    private JLabel caloriesOutput;
    private JLabel sleepQualityOutput;
    private JLabel workedOutOutput;
    private JLabel recordStatus;
    private JLabel dateOutput;

    Controller controller = Controller.getInstance();
    private int recordIndex = controller.getCurrentUser().getNumFitnessRecords() - 1;
    JPanel panel = new JPanel();

    viewFitnessRecord() {

        frame = new JFrame();

        frame.setSize(420, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // adding panel to frame
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);

    }

    private boolean hasRecord() {
        if(controller.currentUser.getFitnessRecords() == null) {
            return false;
        } else {
            return true;
        }
    }

    private void placeComponents(JPanel panel) {
        JLabel label;
        panel.setLayout(null);

        Color color = new Color(103, 146, 103);
        panel.setBackground(color);

        //Creating labels
        label = new JLabel("FITNESS RECORD");
        label.setBounds(100, 0, 250, 50);
        label.setFont(new Font(null, Font.PLAIN, 25));
        panel.add(label);

        label = new JLabel("Date:");
        label.setBounds(105, 60, 120, 25);
        panel.add(label);

        label = new JLabel("Calories:");
        label.setBounds(10, 100, 120, 25);
        panel.add(label);

        label = new JLabel("Sleep Quality:");
        label.setBounds(10, 140, 120, 25);
        panel.add(label);

        label = new JLabel("Worked Out:");
        label.setBounds(10, 180, 120, 25);
        panel.add(label);

        if(hasRecord() && recordIndex >= 0) {
            // Creating user outputs
            dateOutput = new JLabel(controller.getCurrentUser().getFitnessRecords().get(recordIndex).getDate());
            dateOutput.setBounds(145, 60, 120, 25);
            panel.add(dateOutput);

            caloriesOutput = new JLabel(String.valueOf(controller.getCurrentUser().getFitnessRecords().get(recordIndex).getCalories()));
            caloriesOutput.setBounds(110, 100, 120, 25);
            panel.add(caloriesOutput);

            // Creating JLabel
            sleepQualityOutput = new JLabel(controller.getCurrentUser().getFitnessRecords().get(recordIndex).getSleepQuality());
            sleepQualityOutput.setBounds(110, 140, 120, 25);
            panel.add(sleepQualityOutput);

            // Creating JLabel
            workedOutOutput = new JLabel(String.valueOf(controller.getCurrentUser().getFitnessRecords().get(recordIndex).isWorkedOut()));
            workedOutOutput.setBounds(110, 180, 120, 25);
            panel.add(workedOutOutput);
        } else {
         // Creating user outputs
            dateOutput = new JLabel(" ");
            dateOutput.setBounds(145, 60, 120, 25);
            panel.add(dateOutput);

            caloriesOutput = new JLabel(" ");
            caloriesOutput.setBounds(110, 100, 120, 25);
            panel.add(caloriesOutput);

            // Creating JLabel
            sleepQualityOutput = new JLabel(" ");
            sleepQualityOutput.setBounds(110, 140, 120, 25);
            panel.add(sleepQualityOutput);

            // Creating JLabel
            workedOutOutput = new JLabel(" ");
            workedOutOutput.setBounds(110, 180, 120, 25);
            panel.add(workedOutOutput);

            recordStatus = new JLabel("Input Your First Record");
            recordStatus.setBounds(10,350,300,25); //110
            panel.add(recordStatus);
        }



        // Creating input button
        previousWeekButton = new JButton("Previous Day");
        previousWeekButton.setBounds(10, 220, 150, 25);
        previousWeekButton.addActionListener(viewFitnessRecord.this);
        panel.add(previousWeekButton);

        // Creating input button
        nextWeekButton = new JButton("Next Day");
        nextWeekButton.setBounds(210, 220, 150, 25);
        nextWeekButton.addActionListener(viewFitnessRecord.this);
        panel.add(nextWeekButton);

        // Creating input button
        backToMainButton = new JButton("Back to main menu");
        backToMainButton.setBounds(110, 260, 150, 25);
        backToMainButton.addActionListener(viewFitnessRecord.this);
        panel.add(backToMainButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == previousWeekButton) {
            if(recordIndex > 0) {
                recordIndex--;
                updateOutputBoxes();
            }
        }

        if(e.getSource() == nextWeekButton) {
            if(recordIndex < controller.getCurrentUser().getNumFitnessRecords() - 1) {
                recordIndex++;
                updateOutputBoxes();
            }
        }

        if (e.getSource() == backToMainButton) {
            frame.dispose();
            displayMainMenu();
        }
    }

    public void updateOutputBoxes(){
        dateOutput.setText(controller.getCurrentUser().getFitnessRecords().get(recordIndex).getDate());
        caloriesOutput.setText(String.valueOf(controller.getCurrentUser().getFitnessRecords().get(recordIndex).getCalories()));
        sleepQualityOutput.setText(controller.getCurrentUser().getFitnessRecords().get(recordIndex).getSleepQuality());
        workedOutOutput.setText(String.valueOf(controller.getCurrentUser().getFitnessRecords().get(recordIndex).isWorkedOut()));
    }
}
