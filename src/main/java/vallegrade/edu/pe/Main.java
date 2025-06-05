package vallegrade.edu.pe;

import vallegrade.edu.pe.view.ClienteView;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ClienteView view = new ClienteView();
            view.setVisible(true);
        });
    }
}
