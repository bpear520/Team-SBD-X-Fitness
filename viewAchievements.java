import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class viewAchievements extends Display implements ActionListener {

    private static JFrame frame;
    private static JButton backToMainButton;


    Controller controller = Controller.getInstance();

    viewAchievements(){
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

        ImageIcon image = new ImageIcon("crown.png");
        Image crownImage = image.getImage();
        Image modifiedCrownImage = crownImage.getScaledInstance(25,25, Image.SCALE_SMOOTH);
        image = new ImageIcon(modifiedCrownImage);
        JLabel imageLabel = new JLabel();

        Color color = new Color(103, 146, 103);
        panel.setBackground(color);

        //Creating labels
        label = new JLabel("ACHIEVEMENTS");
        label.setBounds(105, 0, 200, 50);
        label.setFont(new Font(null, Font.PLAIN, 25));
        panel.add(label);

        label = new JLabel("Ten Daily Workouts:");
        label.setBounds(10, 60, 135, 25);
        panel.add(label);

        label = new JLabel("Twenty Daily Workouts:");
        label.setBounds(10, 100, 135, 25);
        panel.add(label);

        label = new JLabel("Three Perfect Days:");
        label.setBounds(10, 140, 135, 25);
        panel.add(label);

        label = new JLabel("Six Perfect Days:");
        label.setBounds(210, 60, 135, 25);
        panel.add(label);

        label = new JLabel("Twenty Perfect Days:");
        label.setBounds(210, 100, 135, 25);
        panel.add(label);

        label = new JLabel("Goal Weight Achieved:");
        label.setBounds(210, 140, 135, 25);
        panel.add(label);

        //Creating Achievement checkers
//        if(ACHIEVEMENT STATUS CHECK GOES HERE) {
//            imageLabel.setBounds(155,40,50,50);
//            imageLabel.setIcon(image);
//            panel.add(imageLabel);
//        }
//        if(ACHIEVEMENT STATUS CHECK GOES HERE) {
//            imageLabel.setBounds(155,80,50,50);
//            imageLabel.setIcon(image);
//            panel.add(imageLabel);
//        }
//        if(ACHIEVEMENT STATUS CHECK GOES HERE) {
//            imageLabel.setBounds(155,120,50,50);
//            imageLabel.setIcon(image);
//            panel.add(imageLabel);
//        }
//        if(ACHIEVEMENT STATUS CHECK GOES HERE) {
//            imageLabel.setBounds(255,40,50,50);
//            imageLabel.setIcon(image);
//            panel.add(imageLabel);
//        }
//        if(ACHIEVEMENT STATUS CHECK GOES HERE) {
//            imageLabel.setBounds(255,80,50,50);
//            imageLabel.setIcon(image);
//            panel.add(imageLabel);
//        }
//        if(ACHIEVEMENT STATUS CHECK GOES HERE) {
//            imageLabel.setBounds(255,120,50,50);
//            imageLabel.setIcon(image);
//            panel.add(imageLabel);
//        }

        //Creating back to main menu button
        backToMainButton = new JButton("Back to main menu");
        backToMainButton.setBounds(110, 220, 150, 25);
        backToMainButton.addActionListener(viewAchievements.this);
        panel.add(backToMainButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backToMainButton) {
            frame.dispose();
            displayMainMenu();
        }
    }
}
