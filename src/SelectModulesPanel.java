import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

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
    private JScrollPane unselectListScrollBox;
    private JScrollPane selectListScrollBox;

    private DefaultListModel<Module> unselectedListModel;
    private DefaultListModel<Module> selectedListModel;

    public SelectModulesPanel() {
        addComponents();
    }

    public void addComponents() {

        setLayout(new BorderLayout());
        JPanel unselectPanel = new JPanel();

        unselectList = new JList<>();
        selectList = new JList<>();

        unselectedListModel = new DefaultListModel<>();
        selectedListModel = new DefaultListModel<>();

        unselectPanel.setLayout(new BoxLayout(unselectPanel, BoxLayout.Y_AXIS));
        unselectLabel = new JLabel("Unselected Modules");


        unselectPanel.add(unselectLabel);
        unselectListScrollBox = new JScrollPane();
        unselectListScrollBox.setViewportView(unselectList);
        unselectPanel.add(unselectListScrollBox);

        JPanel selectPanel = new JPanel();
        selectPanel.setLayout(new BoxLayout(selectPanel, BoxLayout.Y_AXIS));
        selectLabel = new JLabel("Selected Modules");

        JPanel currentCreditsPanel = new JPanel(new FlowLayout());
        currentCredLabel = new JLabel("Current Credits:");
        currentCredField = new JTextField(10);
        currentCredField.setEditable(false);
        currentCreditsPanel.add(currentCredLabel);
        currentCreditsPanel.add(currentCredField);
        selectPanel.add(selectLabel);
        selectListScrollBox = new JScrollPane();
        selectListScrollBox.setViewportView(selectList);
        selectPanel.add(selectListScrollBox);
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

    public void addAddActionListener(ActionListener addActionListener) {
        addButton.addActionListener(addActionListener);
    }

    public void addResetActionListener(ActionListener resetActionListener) {
        resetButton.addActionListener(resetActionListener);
    }

    public void addRemoveActionListener(ActionListener removeActionListener) {
        removeButton.addActionListener(removeActionListener);
    }

    public void addSubmitActionListener(ActionListener submitActionListener) {
        submitButton.addActionListener(submitActionListener);
    }

    public DefaultListModel getUnselectedListModel() {
        return unselectedListModel;
    }

    public DefaultListModel getSelectedListModel() {
        return selectedListModel;
    }

    public JList getSelectList() {
        return selectList;
    }

    public JList getUnselectList() {
        return unselectList;
    }

    public void populateUnselectList(DefaultListModel model) {
        unselectList.setModel(model);
    }

    public void populateSelectList(DefaultListModel model) {
        selectList.setModel(model);
    }

    public void updateCredits(Integer credits) {
        currentCredField.setText("" + credits);
    }

}
