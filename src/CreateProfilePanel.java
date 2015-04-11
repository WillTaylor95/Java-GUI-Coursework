import javax.swing.*;
import java.awt.*;

/**
 * Created by Will on 11/04/2015.
 */
public class CreateProfilePanel extends JPanel {

    private JLabel selectCourseJL;
    private JTextField selectCourseTF;

    private JLabel firstNameJL;
    private JTextField firstNameTF;

    private JLabel lastNameJL;
    private JTextField lastNameTF;

    private JLabel pNumberJL;
    private JTextField pNumberTF;

    private JButton createProfileButton;

    public CreateProfilePanel() {
        this.setLayout(new GridLayout(5, 2));
        addComponents();

    }

    public void addComponents() {

        selectCourseJL = new JLabel("Course:");
        selectCourseTF = new JTextField();
        add(selectCourseJL);
        add(selectCourseTF);

        firstNameJL = new JLabel("First Name:");
        firstNameTF = new JTextField();
        add(firstNameJL);
        add(firstNameTF);

        lastNameJL = new JLabel("Last Name:");
        lastNameTF = new JTextField();
        add(lastNameJL);
        add(lastNameTF);

        pNumberJL = new JLabel("P Number:");
        pNumberTF = new JTextField();
        add(pNumberJL);
        add(pNumberTF);

        createProfileButton = new JButton("Create Profile");
        add(createProfileButton);



    }

}
