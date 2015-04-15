

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Will on 11/04/2015.
 */
public class GUIController {

    private GUIView view;
    private ArrayList<Course> courseList;
    private StudentProfile currentStudentProfile;
    private DefaultListModel<Module> selectedListModel;
    private DefaultListModel<Module> unselectedListModel;
    private Integer currentCredits;

    public GUIController(StudentProfile currentStudentProfile, GUIView view) {

        this.currentStudentProfile = currentStudentProfile;
        this.view = view;

        currentCredits = new Integer(0);

        view.addLoadActionListener(new LoadActionListener());
        view.addSaveActionListener(new SaveActionListener());
        view.addExitActionListener(new ExitActionListener());
        view.getCreateProfilePanel().populateCourseList(CreateCourseList());
        view.getCreateProfilePanel().addCreateActionListener(new createProfileActionListener());
        view.getSelectModulesPanel().addAddActionListener(new createAddActionListener());
        view.getSelectModulesPanel().addResetActionListener(new ResetActionListener());
        view.getSelectModulesPanel().addRemoveActionListener(new RemoveActionListener());
        view.getSelectModulesPanel().addSubmitActionListener(new SubmitActionListener());
        view.getOverviewResultsPanel().addSaveOverviewActionListener(new saveOverviewActionListener());
    }


    class LoadActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            load();
        }
    }

    class SaveActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            save();
        }
    }

    class ExitActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private void load() {

        view.getFileChooser().showOpenDialog(view);

        File file = view.getFileChooser().getSelectedFile();

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            currentStudentProfile = (StudentProfile)inputStream.readObject();

            view.getCreateProfilePanel().setSelectCourseCB(currentStudentProfile.getCourse());
            view.getCreateProfilePanel().setFirstNameTF(currentStudentProfile.getStudentName().getFirstName());
            view.getCreateProfilePanel().setLastNameTF(currentStudentProfile.getStudentName().getFamilyName());
            view.getCreateProfilePanel().setpNumberTF(currentStudentProfile.getpNumber());
            view.getSelectModulesPanel().populateUnselectList(populateUnselectList());
            view.getSelectModulesPanel().populateSelectList(populateSelectList());

            for (Module m : currentStudentProfile.getSelectedModules()) {
                selectedListModel.addElement(m);
                unselectedListModel.removeElement(m);
            }
            calculateCurrentCredits();
        }

        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error Loading file", "Load Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void save() {


        view.getFileChooser().showOpenDialog(view);

        File file = view.getFileChooser().getSelectedFile();

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            outputStream.writeObject(currentStudentProfile);
            outputStream.flush();
            JOptionPane.showMessageDialog(null, "Successfully Saved Profile");
        }

        catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving file", "Save Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    class createProfileActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            currentStudentProfile = new StudentProfile();
            currentStudentProfile.setCourse(view.getCreateProfilePanel().getCourseBoxState());
            currentStudentProfile.setStudentName(new Name(view.getCreateProfilePanel().getFirstName(), view.getCreateProfilePanel().getLastName()));
            currentStudentProfile.setpNumber(view.getCreateProfilePanel().getPNumber());
            System.out.println(currentStudentProfile.toString());
            view.getSelectModulesPanel().populateUnselectList(populateUnselectList());
            view.getSelectModulesPanel().populateSelectList(populateSelectList());
            calculateCurrentCredits();
        }
    }

    public ArrayList<Course> CreateCourseList() {

        courseList = new ArrayList<>();

        Module ctec3903 = new Module("CTEC3903", "Software Development Methods", 15, true);
        Module imat3451 = new Module("IMAT3451", "Computing Project", 30, true);
        Module ctec3902_SoftEng = new Module("CTEC3902", "Rigerous Systems", 15, true);
        Module ctec3902_CompSci = new Module("CTEC3902", "Rigerous Systems", 15, false);
        Module ctec3110 = new Module("CTEC3110", "Secure Web Application Development", 15, false);
        Module ctec3426 = new Module("CTEC3426", "Telematics", 15, false);
        Module ctec3604 = new Module("CTEC3604", "Multi-service Networks", 30, false);
        Module imat3404 = new Module("IMAT3404", "Mobile Robotics", 15, false);
        Module imat3406 = new Module("IMAT3406", "Fuzzy Logic and Knowledge Based systems", 15, false);
        Module imat3429 = new Module("IMAT3429", "Privacy and Data Protection", 15, false);
        Module imat3608 = new Module("IMAT3608", "Mobile Games Development", 30, false);
        Module imat3426_CompSci = new Module("IMAT3426", "Information Systems Strategy and Services", 30, false);
        Course compSci = new Course("Computer Science");
        compSci.addModule(ctec3903);
        compSci.addModule(imat3451);
        compSci.addModule(ctec3902_CompSci);
        compSci.addModule(ctec3110);
        compSci.addModule(ctec3426);
        compSci.addModule(ctec3604);
        compSci.addModule(imat3404);
        compSci.addModule(imat3406);
        compSci.addModule(imat3429);
        compSci.addModule(imat3608);
        compSci.addModule(imat3426_CompSci);
        Course softEng = new Course("Software Engineering");
        softEng.addModule(ctec3903);
        softEng.addModule(imat3451);
        softEng.addModule(ctec3902_SoftEng);
        softEng.addModule(ctec3110);
        softEng.addModule(ctec3426);
        softEng.addModule(ctec3604);
        softEng.addModule(imat3404);
        softEng.addModule(imat3406);
        softEng.addModule(imat3429);
        softEng.addModule(imat3608);

        courseList.add(compSci);
        courseList.add(softEng);

        return courseList;

    }

    class createAddActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (!view.getSelectModulesPanel().getUnselectList().isSelectionEmpty()) {
                Module m = (Module) view.getSelectModulesPanel().getUnselectList().getSelectedValue();
                selectedListModel.addElement(m);
                unselectedListModel.removeElement(m);
                calculateCurrentCredits();
            }
        }
    }

    class RemoveActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (!view.getSelectModulesPanel().getSelectList().isSelectionEmpty()) {
                Module m = (Module) view.getSelectModulesPanel().getSelectList().getSelectedValue();
                unselectedListModel.addElement(m);
                selectedListModel.removeElement(m);
                calculateCurrentCredits();
            }
        }
    }

    public DefaultListModel populateUnselectList() {
        unselectedListModel = new DefaultListModel<>();

            for (Module m : currentStudentProfile.getCourse().getModulesOnCourse()) {
                if (!m.isMandatory()) {
                    unselectedListModel.addElement(m);
                }
            }

        return unselectedListModel;
    }




    private DefaultListModel populateSelectList() {

        selectedListModel = new DefaultListModel<>();

        for (Module m : currentStudentProfile.getCourse().getModulesOnCourse()) {
            if (m.isMandatory()) {
                selectedListModel.addElement(m);
                currentStudentProfile.addSelectedModule(m);
            }
        }

        return selectedListModel;

    }

    class ResetActionListener implements ActionListener  {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getSelectModulesPanel().populateSelectList(populateSelectList());
            view.getSelectModulesPanel().populateUnselectList(populateUnselectList());
            calculateCurrentCredits();
        }

    }

    class SubmitActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (currentCredits==120) {
                for (int i = 0; i < selectedListModel.getSize(); i++) {
                    currentStudentProfile.addSelectedModule(selectedListModel.get(i));
                }
                fillOverviewTextArea();
            }

            else
                JOptionPane.showMessageDialog(null, "You need 120 Credits total", "Submit Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    private void calculateCurrentCredits() {
        currentCredits = 0;
        for (int i = 0; i < selectedListModel.getSize(); i++) {
            currentCredits = currentCredits + selectedListModel.get(i).getCredits();
        }

        view.getSelectModulesPanel().updateCredits(currentCredits);

    }

    public void fillOverviewTextArea() {
        view.getOverviewResultsPanel().getOverviewTextArea().setText("Name: " + currentStudentProfile.getStudentName().getFullName() + "\n");
        view.getOverviewResultsPanel().getOverviewTextArea().append("PNo: " + currentStudentProfile.getpNumber() + "\n");
        view.getOverviewResultsPanel().getOverviewTextArea().append("Course: " + currentStudentProfile.getCourse().getCourseName() + "\n\n");
        view.getOverviewResultsPanel().getOverviewTextArea().append("Selected Modules:\n==============\n");
        for (Module m: currentStudentProfile.getSelectedModules()) {
            view.getOverviewResultsPanel().getOverviewTextArea().append("Module Code: " + m.getModuleCode() + "\n");
            view.getOverviewResultsPanel().getOverviewTextArea().append("Credits: " + m.getCredits() + "\n");

            if (m.isMandatory())
                view.getOverviewResultsPanel().getOverviewTextArea().append("Mandatory on your course? yes\n");
            else
                view.getOverviewResultsPanel().getOverviewTextArea().append("Mandatory on your course? no\n");

            view.getOverviewResultsPanel().getOverviewTextArea().append("Module Name: " + m.getModuleName() + "\n\n");
        }
    }

    class saveOverviewActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            view.getFileChooser().showOpenDialog(view);
            File file = view.getFileChooser().getSelectedFile();

            try (PrintWriter printWriter = new PrintWriter(file)) {
                printWriter.print(view.getOverviewResultsPanel().getOverviewText());
            }

            catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "File not Found", "Save Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

}
