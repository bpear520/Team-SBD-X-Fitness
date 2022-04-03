import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class viewPersonalRecord implements ActionListener {

    private static JFrame frame;

    private JLabel firstNameOutput;
    private JLabel surnameOutput;
    private JLabel otherNameOutput;
    private JLabel genderOutput;
    private JLabel titleOutput;
    private JLabel birthOutput;
    private JLabel departmentOutput;
    private JLabel heightOutput;
    private JLabel currentWeightOutput;
    private JLabel goalWeightOutput;
    private JLabel passwordOutput;
    private JLabel adminOutput;

    private static JButton backToMainButton;
    Controller controller = Controller.getInstance();

    viewPersonalRecord() {
        frame = new JFrame();

        frame.setSize(420, 500);
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
        Color color = new Color(103,146,103);
        panel.setBackground(color);

        //Creating Labels
        label = new JLabel("PERSONAL RECORD");
        label.setBounds(75,0,260,50);
        label.setFont(new Font(null,Font.PLAIN,25));
        panel.add(label);

        label = new JLabel("First Name:");
        label.setBounds(10,60,120,25);
        panel.add(label);

        label = new JLabel("Surname:");
        label.setBounds(10,90,120,25);
        panel.add(label);

        label = new JLabel("Other Name:");
        label.setBounds(10,120,120,25);
        panel.add(label);

        label = new JLabel("Title:");
        label.setBounds(10,150,130,25);
        panel.add(label);

        label = new JLabel("Gender:");
        label.setBounds(10,180,130,25);
        panel.add(label);

        label = new JLabel("Date of Birth:");
        label.setBounds(10,210,120,25);
        panel.add(label);

        label = new JLabel("Department:");
        label.setBounds(10,240,120,25);
        panel.add(label);

        label = new JLabel("Height:");
        label.setBounds(10,270,120,25);
        panel.add(label);

        label = new JLabel("Goal Weight:");
        label.setBounds(10,330,120,25);
        panel.add(label);

        label = new JLabel("Current Weight:");
        label.setBounds(10,300,120,25);
        panel.add(label);

        label = new JLabel("Password:");
        label.setBounds(10,360,120,25);
        panel.add(label);

        label = new JLabel("Administrator:");
        label.setBounds(10,390,130,25);
        panel.add(label);

        // Creating JLabel
        firstNameOutput = new JLabel(controller.getCurrentUser().getPersonalrecods().getFirstName());
        firstNameOutput.setBounds(150,60,120,25);
        panel.add(firstNameOutput);

        // Creating JLabel
        surnameOutput = new JLabel(controller.getCurrentUser().getPersonalrecods().getSurName());
        surnameOutput.setBounds(150,90,120,25);
        panel.add(surnameOutput);

        // Creating JLabel
        otherNameOutput = new JLabel(controller.getCurrentUser().getPersonalrecods().getOtherName());
        otherNameOutput.setBounds(150,120,120,25);
        panel.add(otherNameOutput);


        // Creating JLabel
        genderOutput = new JLabel(controller.getCurrentUser().getPersonalrecods().getTitle());
        genderOutput.setBounds(150,150,120,25);
        panel.add(genderOutput);

        // Creating JLabel
        titleOutput = new JLabel(controller.getCurrentUser().getPersonalrecods().getGender());
        titleOutput.setBounds(150,180,120,25);
        panel.add(titleOutput);

        // Creating JLabel
        birthOutput = new JLabel(controller.getCurrentUser().getPersonalrecods().getDOB());
        birthOutput.setBounds(150,210,120,25);
        panel.add(birthOutput);

        // Creating JLabel
        departmentOutput = new JLabel(controller.getCurrentUser().getPersonalrecods().getDepartment());
        departmentOutput.setBounds(150,240,120,25);
        panel.add(departmentOutput);

        // Creating JLabel
        heightOutput = new JLabel(Integer.toString(controller.getCurrentUser().getPersonalrecods().getHeight()));
        heightOutput.setBounds(150,270,120,25);
        panel.add(heightOutput);

        // Creating JLabel
        currentWeightOutput = new JLabel(Integer.toString(controller.getCurrentUser().getPersonalrecods().getWeight()));
        currentWeightOutput.setBounds(150,300,120,25);
        panel.add(currentWeightOutput);

        // Creating JLabel
        goalWeightOutput = new JLabel(Integer.toString(controller.getCurrentUser().getPersonalrecods().getGoalWeight()));
        goalWeightOutput.setBounds(150,330,120,25);
        panel.add(goalWeightOutput);

        // Creating JLabel
        passwordOutput = new JLabel("#");
        passwordOutput.setBounds(150,360,120,25);
        panel.add(passwordOutput);

        // Creating JLabel
        adminOutput = new JLabel(Boolean.toString(controller.getCurrentUser().getPersonalrecods().isAdmin()));
        adminOutput.setBounds(150,390,120,25);
        panel.add(adminOutput);

        // Creating return to main menu button
        backToMainButton = new JButton("Back to main menu");
        backToMainButton.setBounds(110, 420, 150, 25);
        backToMainButton.addActionListener(viewPersonalRecord.this);
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
