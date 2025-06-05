package vallegrade.edu.pe;

import vallegrade.edu.pe.controller.MainMenuController;
import vallegrade.edu.pe.view.MainMenuView;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainMenuView view = new MainMenuView();
            MainMenuController controller = new MainMenuController(view);
            view.setVisible(true);
        });
    }
}
