import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class viewFitnessRecord implements ActionListener {

    private static JFrame frame;
    private static JButton backToMainButton;
    private static JButton previousWeekButton;
    private static JButton nextWeekButton;
    private JLabel caloriesOutput;
    private JLabel sleepQualityOutput;
    private JLabel workedOutOutput;

    viewFitnessRecord() {

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

        // Creating user outputs
        label = new JLabel("###");
        label.setBounds(125, 60, 120, 25);
        panel.add(label);

        caloriesOutput = new JLabel("###");
        caloriesOutput.setBounds(110, 100, 120, 25);
        panel.add(caloriesOutput);

        // Creating JLabel
        sleepQualityOutput = new JLabel("###");
        sleepQualityOutput.setBounds(110, 140, 120, 25);
        panel.add(sleepQualityOutput);

        // Creating JLabel
        workedOutOutput = new JLabel("###");
        workedOutOutput.setBounds(110, 180, 120, 25);
        panel.add(workedOutOutput);

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

        if (e.getSource() == backToMainButton) {
            frame.dispose();
            mainMenu backToMainMenu = new mainMenu();
        }
    }
}
