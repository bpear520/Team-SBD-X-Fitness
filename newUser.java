import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class newUser extends Display implements ActionListener {

    private static JFrame frame;
    private static JLabel statusLabel;

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

    private static String[] titleChoice = {"Mr", "Mrs", "Miss"};
    private static String[] genderChoice = {"Male", "Female"};

    private static JComboBox<String> titleType;
    private static JComboBox<String> genderType;

    private static JButton submitButton;
    private static JButton backToLoginButton;

    Controller controller = Controller.getInstance();

    newUser() {

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
        Color color = new Color(103, 146, 103);
        panel.setBackground(color);

        //Creating Labels
        label = new JLabel("NEW USER");
        label.setBounds(125, 0, 200, 50);
        label.setFont(new Font(null, Font.PLAIN, 25));
        panel.add(label);

        label = new JLabel("First Name:");
        label.setBounds(10, 60, 120, 25);
        panel.add(label);

        label = new JLabel("Surname:");
        label.setBounds(10, 90, 120, 25);
        panel.add(label);

        label = new JLabel("Other Name:");
        label.setBounds(10, 120, 120, 25);
        panel.add(label);

        label = new JLabel("Title:");
        label.setBounds(10, 150, 130, 25);
        panel.add(label);

        label = new JLabel("Gender:");
        label.setBounds(10, 180, 130, 25);
        panel.add(label);

        label = new JLabel("DOB (MM/DD/YYYY):");
        label.setBounds(10, 210, 120, 25);
        panel.add(label);

        label = new JLabel("Department:");
        label.setBounds(10, 240, 120, 25);
        panel.add(label);

        label = new JLabel("Height:");
        label.setBounds(10, 270, 120, 25);
        panel.add(label);

        label = new JLabel("Current Weight:");
        label.setBounds(10, 300, 120, 25);
        panel.add(label);

        label = new JLabel("Goal Weight:");
        label.setBounds(10, 330, 120, 25);
        panel.add(label);

        label = new JLabel("Password:");
        label.setBounds(10, 360, 120, 25);
        panel.add(label);

        label = new JLabel("Administrator:");
        label.setBounds(10, 390, 130, 25);
        panel.add(label);

        //Creating User Fields
        userFirstName = new JTextField(20);
        userFirstName.setBounds(150, 60, 85, 25); //20
        panel.add(userFirstName);

        userSurname = new JTextField(20);
        userSurname.setBounds(150, 90, 85, 25); //20
        panel.add(userSurname);

        userOtherName = new JTextField(20);
        userOtherName.setBounds(150, 120, 85, 25); //20
        panel.add(userOtherName);

        titleType = new JComboBox(titleChoice);
        titleType.setBounds(150, 150, 65, 25);
        panel.add(titleType);

        genderType = new JComboBox(genderChoice);
        genderType.setBounds(150, 180, 65, 25);
        panel.add(genderType);

        userBirth = new JTextField(20);
        userBirth.setBounds(150, 210, 85, 25); //20
        panel.add(userBirth);

        userDepartment = new JTextField(20);
        userDepartment.setBounds(150, 240, 85, 25); //20
        panel.add(userDepartment);

        userHeight = new JTextField(20);
        userHeight.setBounds(150, 270, 85, 25); //20
        panel.add(userHeight);

        userCurrentWeight = new JTextField(20);
        userCurrentWeight.setBounds(150, 300, 85, 25); //20
        panel.add(userCurrentWeight);

        userGoalWeight = new JTextField(20);
        userGoalWeight.setBounds(150, 330, 85, 25); //20
        panel.add(userGoalWeight);

        userPassword = new JPasswordField(20);
        userPassword.setBounds(150, 360, 85, 25); //20
        panel.add(userPassword);

        isAdmin = new JCheckBox();
        isAdmin.setBounds(150, 390, 25, 25);
        panel.add(isAdmin);

        // Creating submission button
        submitButton = new JButton("submit");
        submitButton.setBounds(25, 420, 125, 25); //80
        submitButton.addActionListener(newUser.this);
        panel.add(submitButton);

        // Creating back button
        backToLoginButton = new JButton("Back to login");
        backToLoginButton.setBounds(210, 420, 125, 25);
        backToLoginButton.addActionListener(newUser.this);
        panel.add(backToLoginButton);

        // Creating space for status message
        statusLabel = new JLabel("");
        statusLabel.setBounds(130, 35, 125, 25);
        panel.add(statusLabel);

    }

        @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submitButton) {

            try {
                String firstName = userFirstName.getText();
                String lastName = userSurname.getText();
                String otherName = userOtherName.getText();
                String title = (String) titleType.getSelectedItem();
                String gender = (String) genderType.getSelectedItem();
                String DOB = userBirth.getText();
                String depart = userDepartment.getText();
                int height = Integer.parseInt(userHeight.getText());
                int curWeight = Integer.parseInt(userCurrentWeight.getText());
                int goalWeight = Integer.parseInt(userGoalWeight.getText());
                char[] password = userPassword.getPassword();
                boolean admin = isAdmin.isSelected();

                PersonalRecord newPR = new PersonalRecord(firstName, lastName, otherName, gender, title, DOB, depart, height, curWeight, goalWeight, admin);
                Employee emp = new Employee(null, newPR, String.valueOf(password));
                controller.createNewUser(emp);
                controller.setCurrentUser(firstName, String.valueOf(password));
                controller.writeToFile();
                frame.dispose();
                displayLogin();
            } catch (Exception a) {
                statusLabel.setText("*Please fill in all fields");
            }
        }

        if(e.getSource() == backToLoginButton){
            frame.dispose();
            displayLogin();
        }
    }
}

