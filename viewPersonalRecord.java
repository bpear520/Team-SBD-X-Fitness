import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class viewPersonalRecord implements ActionListener {

    private static JFrame frame;
    private static JLabel title;

    private static JLabel firstNameLabel;
    private static JLabel surnameLabel;
    private static JLabel otherNameLabel;
    private static JLabel genderLabel;
    private static JLabel titleLabel;
    private static JLabel birthLabel;
    private static JLabel departmentLabel;
    private static JLabel heightLabel;
    private static JLabel currentWeightLabel;
    private static JLabel goalWeightLabel;
    private static JLabel passwordLabel;
    private static JLabel adminLabel;

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

    viewPersonalRecord() {
        frame = new JFrame();

        frame.setSize(420, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        // adding panel to frame
        frame.add(panel);

        placeComponents(panel);

        frame.setVisible(true);

    }


    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        title = new JLabel("PERSONAL RECORD");
        title.setBounds(75,0,260,50);
        title.setFont(new Font(null,Font.PLAIN,25));
        panel.add(title);


        // Creating JLabel
        firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(10,60,120,25);
        panel.add(firstNameLabel);

        // Creating JLabel
        firstNameOutput = new JLabel("#");
        firstNameOutput.setBounds(150,60,120,25);
        panel.add(firstNameOutput);

        // Creating JLabel
        surnameLabel = new JLabel("Surname:");
        surnameLabel.setBounds(10,90,120,25);
        panel.add(surnameLabel);

        // Creating JLabel
        surnameOutput = new JLabel("#");
        surnameOutput.setBounds(150,90,120,25);
        panel.add(surnameOutput);

        // Creating JLabel
        otherNameLabel = new JLabel("Other Name:");
        otherNameLabel.setBounds(10,120,120,25);
        panel.add(otherNameLabel);

        // Creating JLabel
        otherNameOutput = new JLabel("#");
        otherNameOutput.setBounds(150,120,120,25);
        panel.add(otherNameOutput);

        // Creating Title Choices
        titleLabel = new JLabel("Title:");
        titleLabel.setBounds(10,150,130,25);
        panel.add(titleLabel);

        // Creating JLabel
        genderOutput = new JLabel("#");
        genderOutput.setBounds(150,150,120,25);
        panel.add(genderOutput);

        // Creating Title Choices
        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(10,180,130,25);
        panel.add(genderLabel);

        // Creating JLabel
        titleOutput = new JLabel("#");
        titleOutput.setBounds(150,180,120,25);
        panel.add(titleOutput);

        // Creating JLabel
        birthLabel = new JLabel("Date of Birth:");
        birthLabel.setBounds(10,210,120,25);
        panel.add(birthLabel);

        // Creating JLabel
        birthOutput = new JLabel("#");
        birthOutput.setBounds(150,210,120,25);
        panel.add(birthOutput);

        // Creating JLabel
        departmentLabel = new JLabel("Department:");
        departmentLabel.setBounds(10,240,120,25);
        panel.add(departmentLabel);

        // Creating JLabel
        departmentOutput = new JLabel("#");
        departmentOutput.setBounds(150,240,120,25);
        panel.add(departmentOutput);

        // Creating JLabel
        heightLabel = new JLabel("Height:");
        heightLabel.setBounds(10,270,120,25);
        panel.add(heightLabel);

        // Creating JLabel
        heightOutput = new JLabel("#");
        heightOutput.setBounds(150,270,120,25);
        panel.add(heightOutput);

        // Creating JLabel
        currentWeightLabel = new JLabel("Current Weight:");
        currentWeightLabel.setBounds(10,300,120,25);
        panel.add(currentWeightLabel);

        // Creating JLabel
        currentWeightOutput = new JLabel("#");
        currentWeightOutput.setBounds(150,300,120,25);
        panel.add(currentWeightOutput);

        // Creating JLabel
        goalWeightLabel = new JLabel("Goal Weight:");
        goalWeightLabel.setBounds(10,330,120,25);
        panel.add(goalWeightLabel);

        // Creating JLabel
        goalWeightOutput = new JLabel("#");
        goalWeightOutput.setBounds(150,330,120,25);
        panel.add(goalWeightOutput);

        // Creating JLabel
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10,360,120,25);
        panel.add(passwordLabel);

        // Creating JLabel
        passwordOutput = new JLabel("#");
        passwordOutput.setBounds(150,360,120,25);
        panel.add(passwordOutput);

        // Creating Title Choices
        adminLabel = new JLabel("Administrator:");
        adminLabel.setBounds(10,390,130,25);
        panel.add(adminLabel);

        // Creating JLabel
        adminOutput = new JLabel("#");
        adminOutput.setBounds(150,390,120,25);
        panel.add(adminOutput);

        // Creating input button
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
