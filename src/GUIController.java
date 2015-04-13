import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Will on 11/04/2015.
 */
public class GUIController {

    private GUIModel model;
    private GUIView view;

    public GUIController(GUIModel model, GUIView view) {

        this.model = model;
        this.view = view;

        view.addLoadActionListener(new LoadActionListener());
        view.addSaveActionListener(new SaveActionListener());
        view.addExitActionListener(new ExitActionListener());

        view.populateCourseBox(CreateCourseList());



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

    public ArrayList CreateCourseList() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/Courses.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        scanner.useDelimiter("\\n");

        ArrayList<String> courseStrings = new ArrayList<>();

        while (scanner.hasNextLine()) {
            courseStrings.add(scanner.next());
        }

        scanner.close();

        ArrayList<Course> courseList = new ArrayList<>();

        for (String s : courseStrings) {
            int index = 0;
            String[] splitCourse = s.split("\\[<>]+");
            courseList.add(new Course(splitCourse[0]));
            for (int i = 1; i < splitCourse.length; i++) {
                courseList.get(index).addModule(new Module(splitCourse[i], "RandomTitle"));
            }

        }

        return courseList;

    }




}
