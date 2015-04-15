import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Will on 11/04/2015.
 */
public class CreateProfilePanel extends JPanel {

    private JLabel selectCourseJL;
    private JComboBox selectCourseCB;

    private JLabel firstNameJL;
    private JTextField firstNameTF;

    private JLabel lastNameJL;
    private JTextField lastNameTF;

    private JLabel pNumberJL;
    private JTextField pNumberTF;

    private JButton createProfileButton;

    public CreateProfilePanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addComponents();

    }

    public void addComponents() {

        JPanel selectCoursePanel = new JPanel(new FlowLayout());
        JPanel firstNamePanel = new JPanel(new FlowLayout());
        JPanel lastNamePanel = new JPanel(new FlowLayout());
        JPanel pNumberPanel = new JPanel(new FlowLayout());

        selectCourseJL = new JLabel("Course:");
        selectCourseCB = new JComboBox();
        selectCoursePanel.add(selectCourseJL);
        selectCoursePanel.add(selectCourseCB);

        firstNameJL = new JLabel("First Name:");
        firstNameTF = new JTextField(10);
        firstNamePanel.add(firstNameJL);
        firstNamePanel.add(firstNameTF);

        lastNameJL = new JLabel("Last Name:");
        lastNameTF = new JTextField(10);
        lastNamePanel.add(lastNameJL);
        lastNamePanel.add(lastNameTF);

        pNumberJL = new JLabel("P Number:");
        pNumberTF = new JTextField(10);
        pNumberPanel.add(pNumberJL);
        pNumberPanel.add(pNumberTF);

        createProfileButton = new JButton("Create Profile");

        add(selectCoursePanel);
        add(firstNamePanel);
        add(lastNamePanel);
        add(pNumberPanel);

        add(createProfileButton);

    }

    public void populateCourseList(ArrayList<Course> courseList) {
        for (Course c : courseList) {
            selectCourseCB.addItem(c);
        }
    }

    public void addCreateActionListener(ActionListener createAL) {
        createProfileButton.addActionListener(createAL);
    }


    public Course getCourseBoxState() {
        return (Course)selectCourseCB.getSelectedItem();
    }

    public String getFirstName() {
        return firstNameTF.getText();
    }

    public String getLastName() {
        return lastNameTF.getText();
    }

    public String getPNumber() {
        return pNumberTF.getText();
    }

    public void setSelectCourseCB(Course course) {
        selectCourseCB.setSelectedItem(course);
    }

    public void setFirstNameTF(String s) {
        firstNameTF.setText(s);
    }

    public void setLastNameTF(String s) {
        lastNameTF.setText(s);
    }

    public void setpNumberTF(String s) {
        pNumberTF.setText(s);
    }

}
