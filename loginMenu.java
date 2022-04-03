import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class loginMenu extends Display implements ActionListener {

    private static JTextField userText;
    private static JPasswordField passwordText;
    private static JButton loginButton;
    private static JLabel success;
    private static JButton newUserButton;
    private static JFrame frame;
    private String firstName;
    private char[] password;

    Controller controller = Controller.getInstance();

    loginMenu() {
        // Creating instance of JFrame
        frame = new JFrame("X-Fitness Login");
        // Setting the width and height of frame
        frame.setSize(400, 420);
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

       // Color color = new Color(103,146,103);
        //panel.setBackground(color);

        ImageIcon image = new ImageIcon("dude.png");

        // Creating image
        JLabel imageLabel = new JLabel();
        imageLabel.setBounds(80,20,210,210); //20
        imageLabel.setIcon(image);
        panel.add(imageLabel);

        //Creating labels for screen
        label = new JLabel("User");
        label.setBounds(10,250,80,25);
        panel.add(label);

        label = new JLabel("Password");
        label.setBounds(10,280,80,25); //50
        panel.add(label);

        //Creating user text fields
        userText = new JTextField(20);
        userText.setBounds(100,250,165,25); //20
        panel.add(userText);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(100,280,165,25); //50
        panel.add(passwordText);

        // Creating login button
        loginButton = new JButton("login");
        loginButton.setBounds(25, 320, 125, 25); //80
        loginButton.addActionListener(loginMenu.this);
        panel.add(loginButton);

        // Creating new user button
        newUserButton = new JButton("New User");
        newUserButton.setBounds(210, 320, 125, 25); //80
        newUserButton.addActionListener(loginMenu.this);
        panel.add(newUserButton);

        success = new JLabel("");
        success.setBounds(10,350,300,25); //110
        panel.add(success);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        firstName = userText.getText().trim();
        password = passwordText.getPassword();

        if(e.getSource() == loginButton) {

            if(controller.containsLogIn(firstName, String.valueOf(password))) {
                success();
            } else {
                doesNotExist();
            }
        }

        if(e.getSource() == newUserButton) {
            frame.dispose();
            displayNewUser();
        }
    }

    public void success() {
        success.setText("Login Successful!");
        controller.setCurrentUser(controller.getExistingUser(firstName, String.valueOf(password)));
        frame.dispose();
        displayMainMenu();
    }

    public void doesNotExist() {
        success.setText("Please try again.");
    }

    public String getfirstName() {
        return firstName;
    }

    public String getPassWord() {
        return String.valueOf(password);
    }
}
