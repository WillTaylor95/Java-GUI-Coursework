import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Will on 11/04/2015.
 */
public class OverviewResultsPanel extends JPanel {

    private JScrollPane scrollPane;
    private JTextArea overviewTextArea;
    private JButton saveOverviewButton;

    public OverviewResultsPanel() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addComponents();
    }

    public void addComponents() {

        overviewTextArea = new JTextArea(20, 20);
        overviewTextArea.setEditable(false);
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(overviewTextArea);

        saveOverviewButton = new JButton("Save Overview");

        JPanel buttons = new JPanel(new FlowLayout());
        buttons.add(saveOverviewButton);
        add(scrollPane);
        add(buttons);

    }

    public JTextArea getOverviewTextArea() {
        return overviewTextArea;
    }

    public void addSaveOverviewActionListener(ActionListener saveActionListener) {
        saveOverviewButton.addActionListener(saveActionListener);
    }

    public String getOverviewText() {
        return overviewTextArea.getText();
    }

}
