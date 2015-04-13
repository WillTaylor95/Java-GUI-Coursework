import com.sun.org.apache.xpath.internal.operations.Mod;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Will on 11/04/2015.
 */
public class SelectModulesPanel extends JPanel {

    private JLabel unselectLabel;
    private JLabel selectLabel;
    private JList<Module> unselectList;
    private JList<Module> selectList;
    private JLabel currentCredLabel;
    private JTextField currentCredField;
    private JButton resetButton;
    private JButton removeButton;
    private JButton addButton;
    private JButton submitButton;

    public SelectModulesPanel() {


        addComponents();

    }

    public void addComponents() {

        setLayout(new BorderLayout());
        JPanel unselectPanel = new JPanel();
        unselectPanel.setLayout(new BoxLayout(unselectPanel, BoxLayout.Y_AXIS));
        unselectLabel = new JLabel("Unselected Modules");

        DefaultListModel<Module> model = new DefaultListModel<>();

        unselectList = new JList<>();
        unselectPanel.add(unselectLabel);
        unselectPanel.add(unselectList);

        JPanel selectPanel = new JPanel();
        selectPanel.setLayout(new BoxLayout(selectPanel, BoxLayout.Y_AXIS));
        selectLabel = new JLabel("Selected Modules");
        selectList = new JList<>();
        JPanel currentCreditsPanel = new JPanel(new FlowLayout());
        currentCredLabel = new JLabel("Current Credits:");
        currentCredField = new JTextField(10);
        currentCreditsPanel.add(currentCredLabel);
        currentCreditsPanel.add(currentCredField);
        selectPanel.add(selectLabel);
        selectPanel.add(selectList);
        selectPanel.add(currentCreditsPanel);

        JPanel buttonsPanel = new JPanel(new FlowLayout());
        resetButton = new JButton("Reset");
        removeButton = new JButton("Remove");
        addButton = new JButton("Add");
        submitButton = new JButton("Submit");
        buttonsPanel.add(resetButton);
        buttonsPanel.add(removeButton);
        buttonsPanel.add(addButton);
        buttonsPanel.add(submitButton);

        add(unselectPanel, BorderLayout.LINE_START);
        add(selectPanel, BorderLayout.LINE_END);
        add(buttonsPanel, BorderLayout.PAGE_END);

    }

}
