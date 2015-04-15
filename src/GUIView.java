import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by Will on 11/04/2015.
 */
public class GUIView extends JFrame {

    private JMenuBar menuBar;
    private CreateProfilePanel createProfilePanel;
    private SelectModulesPanel selectModulesPanel;
    private OverviewResultsPanel overviewResultsPanel;
    private JMenuItem loadStudentDataItem;
    private JMenuItem saveStudentDataItem;
    private JMenuItem exitItem;
    private JFileChooser fileChooser;

    public GUIView(StudentProfile model) {

        setTitle("Final Year Module Chooser");
        setSize(700, 500);

        CreateMenuBar();
        CreateTabbedPane();
        fileChooser = new JFileChooser();

    }

    public void CreateMenuBar() {

        menuBar = new JMenuBar();


        JMenu fileMenuButton = new JMenu("File");
        fileMenuButton.setMnemonic(KeyEvent.VK_F);

        loadStudentDataItem = new JMenuItem("Load Student Data");
        loadStudentDataItem.setMnemonic(KeyEvent.VK_L);

        saveStudentDataItem = new JMenuItem("Save Student Data");
        saveStudentDataItem.setMnemonic(KeyEvent.VK_S);

        exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic(KeyEvent.VK_E);

        fileMenuButton.add(loadStudentDataItem);
        fileMenuButton.add(saveStudentDataItem);
        fileMenuButton.add(exitItem);

        menuBar.add(fileMenuButton);

        setJMenuBar(menuBar);
    }

    public void CreateTabbedPane() {

        createProfilePanel = new CreateProfilePanel();
        selectModulesPanel = new SelectModulesPanel();
        overviewResultsPanel = new OverviewResultsPanel();

        JTabbedPane tabPane = new JTabbedPane();

        tabPane.addTab("Create Profile", createProfilePanel);
        tabPane.addTab("Select Modules", selectModulesPanel);
        tabPane.addTab("Overview Results", overviewResultsPanel);

        add(tabPane);

    }

    public void addLoadActionListener(ActionListener loadAL) {
        loadStudentDataItem.addActionListener(loadAL);
    }

    public void addSaveActionListener(ActionListener saveAL) {
        saveStudentDataItem.addActionListener(saveAL);
    }

    public void addExitActionListener(ActionListener exitAL) {
        exitItem.addActionListener(exitAL);
    }

    public CreateProfilePanel getCreateProfilePanel() {
        return createProfilePanel;
    }

    public SelectModulesPanel getSelectModulesPanel() {
        return selectModulesPanel;
    }

    public OverviewResultsPanel getOverviewResultsPanel() {
        return overviewResultsPanel;
    }

    public JFileChooser getFileChooser() {
        return fileChooser;
    }
}
