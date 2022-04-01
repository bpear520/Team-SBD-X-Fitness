import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class newUser extends Display implements ActionListener {

    private static JFrame frame;
    private static JLabel title;

    private static JLabel surnameLabel;
    private static JLabel firstNameLabel;
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

    private static JTextField userSurname;
    private static JTextField userFirstName;
    private static JTextField userOtherName;
    private static JTextField userBirth;
    private static JTextField userDepartment;
    private static JTextField userHeight;
    private static JTextField userCurrentWeight;
    private static JTextField userGoalWeight;
    private static JPasswordField userPassword;

    private static JCheckBox isAdmin;

    private static String[] titleChoice = {"Mr","Mrs","Miss"};
    private static String[] genderChoice = {"Male","Female"};

    private static JComboBox<String> titleType;
    private static JComboBox<String> genderType;

    private static JButton submitButton;

    Controller controller = Controller.getInstance();

    newUser() {

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

        title = new JLabel("NEW USER");
        title.setBounds(100,0,200,50);
        title.setFont(new Font(null,Font.PLAIN,25));
        panel.add(title);


        // Creating JLabel
        firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(10,60,120,25);
        panel.add(firstNameLabel);

        userFirstName = new JTextField(20);
        userFirstName.setBounds(150,60,85,25); //20
        panel.add(userFirstName);

        // Creating JLabel
        surnameLabel = new JLabel("Surname:");
        surnameLabel.setBounds(10,90,120,25);
        panel.add(surnameLabel);

        userSurname = new JTextField(20);
        userSurname.setBounds(150,90,85,25); //20
        panel.add(userSurname);

        // Creating JLabel
        otherNameLabel = new JLabel("Other Name:");
        otherNameLabel.setBounds(10,120,120,25);
        panel.add(otherNameLabel);

        userOtherName = new JTextField(20);
        userOtherName.setBounds(150,120,85,25); //20
        panel.add(userOtherName);

        // Creating Title Choices
        titleLabel = new JLabel("Title:");
        titleLabel.setBounds(10,150,130,25);
        panel.add(titleLabel);

        titleType = new JComboBox(titleChoice);
        titleType.setBounds(150, 150, 65, 25);
        panel.add(titleType);

        // Creating Title Choices
        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(10,180,130,25);
        panel.add(genderLabel);

        genderType = new JComboBox(genderChoice);
        genderType.setBounds(150, 180, 65, 25);
        panel.add(genderType);

        // Creating JLabel
        birthLabel = new JLabel("Date of Birth:");
        birthLabel.setBounds(10,210,120,25);
        panel.add(birthLabel);

        userBirth = new JTextField(20);
        userBirth.setBounds(150,210,85,25); //20
        panel.add(userBirth);

        // Creating JLabel
        departmentLabel = new JLabel("Department:");
        departmentLabel.setBounds(10,240,120,25);
        panel.add(departmentLabel);

        userDepartment = new JTextField(20);
        userDepartment.setBounds(150,240,85,25); //20
        panel.add(userDepartment);

        // Creating JLabel
        heightLabel = new JLabel("Height:");
        heightLabel.setBounds(10,270,120,25);
        panel.add(heightLabel);

        userHeight = new JTextField(20);
        userHeight.setBounds(150,270,85,25); //20
        panel.add(userHeight);

        // Creating JLabel
        currentWeightLabel = new JLabel("Current Weight:");
        currentWeightLabel.setBounds(10,300,120,25);
        panel.add(currentWeightLabel);

        userCurrentWeight = new JTextField(20);
        userCurrentWeight.setBounds(150,300,85,25); //20
        panel.add(userCurrentWeight);

        // Creating JLabel
        goalWeightLabel = new JLabel("Goal Weight:");
        goalWeightLabel.setBounds(10,330,120,25);
        panel.add(goalWeightLabel);

        userGoalWeight = new JTextField(20);
        userGoalWeight.setBounds(150,330,85,25); //20
        panel.add(userGoalWeight);

        // Creating JLabel
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10,360,120,25);
        panel.add(passwordLabel);

        userPassword = new JPasswordField(20);
        userPassword.setBounds(150,360,85,25); //20
        panel.add(userPassword);

        // Creating Title Choices
        adminLabel = new JLabel("Administrator:");
        adminLabel.setBounds(10,390,130,25);
        panel.add(adminLabel);

        isAdmin = new JCheckBox();
        isAdmin.setBounds(150, 390, 25, 25);
        panel.add(isAdmin);

        // Creating login button
        submitButton = new JButton("submit");
        submitButton.setBounds(10, 420, 80, 25); //80
        submitButton.addActionListener(newUser.this);
        panel.add(submitButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == submitButton) {

            String firstName = userFirstName.getText();
            String lastName = userSurname.getText();
            String otherName = userOtherName.getText();
            String title = (String)titleType.getSelectedItem();
            String gender = (String)genderType.getSelectedItem();
            String DOB = userBirth.getText();
            String depart = userDepartment.getText();

            int height = Integer.parseInt(userHeight.getText());
            int curWeight = Integer.parseInt(userCurrentWeight.getText());
            int goalWeight = Integer.parseInt(userGoalWeight.getText());
            char[] password = userPassword.getPassword();
            boolean admin = isAdmin.isSelected();

            PersonalRecord newPR = new PersonalRecord(firstName, lastName, otherName, gender, title, DOB, depart,
                    height, curWeight, goalWeight);

            if(admin) {
                Administrator admn = new Administrator(null, newPR, String.valueOf(password));
                controller.createNewUser(admn);
            } else {
                Employee emp = new Employee(null, newPR, String.valueOf(password));
                controller.createNewUser(emp);
            }
            controller.setCurrentUser(firstName, String.valueOf(password));
            frame.dispose();
            displayLogin();
        }
    }
}
