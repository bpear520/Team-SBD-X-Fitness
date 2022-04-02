import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainMenu implements ActionListener {

    private static JFrame frame;

    private static JButton inputButton;
    private static JButton viewRecordButton;
    private static JButton viewPersonalButton;
    private static JButton viewReportButton;
    private static JButton backToLoginButton;

    Controller controller = Controller.getInstance();

    private String user = controller.currentUser.getPassword();

    mainMenu() {

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

        label = new JLabel("X-FITNESS");
        label.setBounds(140, 0, 175, 50);
        label.setFont(new Font(null, Font.PLAIN, 25));
        panel.add(label);


        // Creating input button
        inputButton = new JButton("Input daily record");
        inputButton.setBounds(100, 60, 200, 25);
        inputButton.addActionListener(mainMenu.this);
        panel.add(inputButton);

        // Creating input button
        viewRecordButton = new JButton("View daily fitness record");
        viewRecordButton.setBounds(100, 100, 200, 25);
        viewRecordButton.addActionListener(mainMenu.this);
        panel.add(viewRecordButton);

        // Creating input button
        viewPersonalButton = new JButton("View personal record");
        viewPersonalButton.setBounds(100, 140, 200, 25);
        viewPersonalButton.addActionListener(mainMenu.this);
        panel.add(viewPersonalButton);

        if(controller.getCurrentUser().getPersonalrecods().isAdmin()) {
            // Creating input button
            viewReportButton = new JButton("View employee reports");
            viewReportButton.setBounds(100, 180, 200, 25);
            viewReportButton.addActionListener(mainMenu.this);
            panel.add(viewReportButton);

            // Creating input button
            backToLoginButton = new JButton("Back to login");
            backToLoginButton.setBounds(100, 220, 200, 25);
            backToLoginButton.addActionListener(mainMenu.this);
            panel.add(backToLoginButton);
        } else {
            // Creating input button
            backToLoginButton = new JButton("Back to login");
            backToLoginButton.setBounds(100, 180, 200, 25);
            backToLoginButton.addActionListener(mainMenu.this);
            panel.add(backToLoginButton);
        }

        // Creating JLabel
        label = new JLabel("Current user:");
        label.setBounds(10, 260, 100, 25);
        panel.add(label);

        // Creating JLabel
        label = new JLabel(controller.getCurrentUser().getPersonalrecods().getFirstName());
        label.setBounds(100, 260, 100, 25);
        panel.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == inputButton) {
            frame.dispose();
            inputDailyRecord dailyRecord = new inputDailyRecord();
        }

        if (e.getSource() == viewRecordButton) {
            frame.dispose();
            viewFitnessRecord viewFitRec = new viewFitnessRecord();
        }

        if (e.getSource() == viewPersonalButton) {
            frame.dispose();
            viewPersonalRecord viewPerRec = new viewPersonalRecord();
        }

        if (e.getSource() == viewReportButton) {
            frame.dispose();
            employeeReports viewReps = new employeeReports();
        }

        if (e.getSource() == backToLoginButton) {
            frame.dispose();
            loginMenu backToLogin = new loginMenu();
        }

    }
}
