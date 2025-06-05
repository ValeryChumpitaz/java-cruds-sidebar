package vallegrade.edu.pe;

import vallegrade.edu.pe.controller.MenuController;
import vallegrade.edu.pe.view.MenuView;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            MenuView menuView = new MenuView();
            new MenuController(menuView);
            menuView.setVisible(true);
        });
    }
}
