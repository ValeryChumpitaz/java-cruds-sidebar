package vallegrade.edu.pe.controller;

import vallegrade.edu.pe.view.ClientesView;
import vallegrade.edu.pe.view.MenuView;
import vallegrade.edu.pe.view.ProductosView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MenuController {
    private MenuView menuView;

    public MenuController(MenuView menuView) {
        this.menuView = menuView;
        initController();
    }

    private void initController() {
        menuView.getBtnClientes().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarVista(new ClientesView());
            }
        });

        menuView.getBtnProductos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarVista(new ProductosView());
            }
        });
    }

    // Método para cambiar dinámicamente el contenido
    private void mostrarVista(JPanel vista) {
        JPanel panelContenido = menuView.getPanelContenido();
        panelContenido.removeAll();
        panelContenido.add(vista);
        panelContenido.revalidate();
        panelContenido.repaint();
    }
}
