import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


}
