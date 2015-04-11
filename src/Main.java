/**
 * Created by Will on 11/04/2015.
 */
public class Main {

    public static void main(String[] args) {

        GUIModel model = new GUIModel();
        GUIView view = new GUIView(model);
        GUIController controller = new GUIController(model, view);

        view.setVisible(true);

    }

}
