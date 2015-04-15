import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Will on 11/04/2015.
 */
public class GUIController {

    private GUIModel model;
    private GUIView view;
    private ArrayList<Course> courseList;
    private StudentProfile currentStudentProfile;

    public GUIController(GUIModel model, GUIView view) {

        this.model = model;
        this.view = view;

        view.addLoadActionListener(new LoadActionListener());
        view.addSaveActionListener(new SaveActionListener());
        view.addExitActionListener(new ExitActionListener());
        view.getCreateProfilePanel().populateCourseList(CreateCourseList());
        view.getCreateProfilePanel().addCreateActionListener(new createProfileActionListener());
        view.getSelectModulesPanel().addAddActionListener(new createAddActionListener());
    }


    class LoadActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class SaveActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class ExitActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    class createProfileActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            currentStudentProfile = new StudentProfile();
            currentStudentProfile.setCourse(view.getCreateProfilePanel().getCourseBoxState());
            currentStudentProfile.setStudentName(new Name(view.getCreateProfilePanel().getFirstName(), view.getCreateProfilePanel().getLastName()));
            currentStudentProfile.setpNumber(view.getCreateProfilePanel().getPNumber());
            populateUnselectList();
            System.out.println(currentStudentProfile.toString());
            view.getSelectModulesPanel().populateUnselectList(populateUnselectList());
            view.getSelectModulesPanel().populateSelectList(populateSelectList());
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

            Module m = (Module)view.getSelectModulesPanel().getUnselectList().getSelectedValue();

            view.getSelectModulesPanel().getUnselectedListModel().addElement(m);
            view.getSelectModulesPanel().getUnselectedListModel().removeElement(m);

        }
    }

    public DefaultListModel populateUnselectList() {
        DefaultListModel<Module> unselectModel = new DefaultListModel<>();

            for (Module m : currentStudentProfile.getCourse().getModulesOnCourse()) {
                unselectModel.addElement(m);
            }

        return unselectModel;
    }




    private DefaultListModel populateSelectList() {
        DefaultListModel<Module> selectModel = new DefaultListModel<>();

        for (Module m : currentStudentProfile.getCourse().getModulesOnCourse()) {
            if (m.isMandatory()) {
                selectModel.addElement(m);
            }
        }

        return selectModel;

    }




}
