package vallegrade.edu.pe;

import vallegrade.edu.pe.controller.ProductoController;
import vallegrade.edu.pe.service.ProductoService;
import vallegrade.edu.pe.view.ProductoView;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProductoView view = new ProductoView();
            ProductoService service = new ProductoService();
            ProductoController controller = new ProductoController(view, service);
            view.setVisible(true);
        });
    }
}
    