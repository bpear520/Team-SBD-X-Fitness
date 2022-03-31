import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginMenu implements ActionListener {

    private static JLabel userLabel;
    private static JLabel imageLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton loginButton;
    private static JLabel success;
    private static JButton newUserButton;
    private static JFrame frame;

    loginMenu() {
        // Creating instance of JFrame
        frame = new JFrame("X-Fitness Login");
        // Setting the width and height of frame
        frame.setSize(420, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        // adding panel to frame
        frame.add(panel);

        placeComponents(panel);

        frame.setVisible(true);
    }


    private void placeComponents(JPanel panel) {

        panel.setLayout(null);

        ImageIcon image = new ImageIcon("dude.png");

        // Creating image
        imageLabel = new JLabel();
        imageLabel.setBounds(65,20,210,210); //20
        imageLabel.setIcon(image);
        panel.add(imageLabel);

        // Creating JLabel
        userLabel = new JLabel("User");
        userLabel.setBounds(10,250,80,25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100,250,165,25); //20
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,280,80,25); //50
        panel.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(100,280,165,25); //50
        panel.add(passwordText);


        // Creating login button
        loginButton = new JButton("login");
        loginButton.setBounds(25, 320, 80, 25); //80
        loginButton.addActionListener(loginMenu.this);
        panel.add(loginButton);

        // Creating new user button
        newUserButton = new JButton("New User");
        newUserButton.setBounds(125, 320, 100, 25); //80
        newUserButton.addActionListener(loginMenu.this);
        panel.add(newUserButton);

        success = new JLabel("");
        success.setBounds(10,350,300,25); //110
        panel.add(success);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = passwordText.getText();

        if(e.getSource() == loginButton) {
            if (user.equals("Brock") && password.equals("1")) {
                success.setText("Login Successful!");
                frame.dispose();
                mainMenu menu = new mainMenu();
            } else {
                success.setText("Please try again.");
            }
        }

        if(e.getSource() == newUserButton) {
            frame.dispose();
            newUser newUserCreate = new newUser();
        }
    }
}
