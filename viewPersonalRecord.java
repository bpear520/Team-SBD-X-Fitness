import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        // Creating User Outputs
        firstNameOutput = new JLabel("#");
        firstNameOutput.setBounds(150,60,120,25);
        panel.add(firstNameOutput);

        surnameOutput = new JLabel("#");
        surnameOutput.setBounds(150,90,120,25);
        panel.add(surnameOutput);

        otherNameOutput = new JLabel("#");
        otherNameOutput.setBounds(150,120,120,25);
        panel.add(otherNameOutput);

        genderOutput = new JLabel("#");
        genderOutput.setBounds(150,150,120,25);
        panel.add(genderOutput);

        titleOutput = new JLabel("#");
        titleOutput.setBounds(150,180,120,25);
        panel.add(titleOutput);

        birthOutput = new JLabel("#");
        birthOutput.setBounds(150,210,120,25);
        panel.add(birthOutput);

        departmentOutput = new JLabel("#");
        departmentOutput.setBounds(150,240,120,25);
        panel.add(departmentOutput);

        heightOutput = new JLabel("#");
        heightOutput.setBounds(150,270,120,25);
        panel.add(heightOutput);

        currentWeightOutput = new JLabel("#");
        currentWeightOutput.setBounds(150,300,120,25);
        panel.add(currentWeightOutput);

        goalWeightOutput = new JLabel("#");
        goalWeightOutput.setBounds(150,330,120,25);
        panel.add(goalWeightOutput);

        passwordOutput = new JLabel("#");
        passwordOutput.setBounds(150,360,120,25);
        panel.add(passwordOutput);

        adminOutput = new JLabel("#");
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
