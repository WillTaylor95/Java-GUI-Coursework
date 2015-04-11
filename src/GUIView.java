import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Created by Will on 11/04/2015.
 */
public class GUIView extends JFrame {

    private JMenuBar menuBar;
    private CreateProfilePane createProfilePane;
    private SelectModulesPane selectModulesPane;
    private OverviewResultsPane overviewResultsPane;

    public GUIView(GUIModel model) {

        CreateMenuBar();


    }

    public void CreateMenuBar() {

        menuBar = new JMenuBar();

        JMenu fileMenuButton = new JMenu("File");
        fileMenuButton.setMnemonic(KeyEvent.VK_F);

        JMenuItem loadStudentDataButton = new JMenuItem("Load Student Data");
        loadStudentDataButton.setMnemonic(KeyEvent.VK_L);

        JMenuItem saveStudentDataButton = new JMenuItem("Save Student Data");
        saveStudentDataButton.setMnemonic(KeyEvent.VK_S);

        JMenuItem exitButton = new JMenuItem("Exit");
        exitButton.setMnemonic(KeyEvent.VK_E);

        fileMenuButton.add(loadStudentDataButton);
        fileMenuButton.add(saveStudentDataButton);
        fileMenuButton.add(exitButton);

        menuBar.add(fileMenuButton);

        setJMenuBar(menuBar);



    }

}
