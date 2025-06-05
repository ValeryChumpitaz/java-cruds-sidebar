package vallegrade.edu.pe.controller;

import vallegrade.edu.pe.view.MainMenuView;

import javax.swing.*;

public class MainMenuController {
    private final MainMenuView view;

    public MainMenuController(MainMenuView view) {
        this.view = view;

        view.getBtnClientes().addActionListener(e ->
                JOptionPane.showMessageDialog(view, "Clientes aún no implementado")
        );

        view.getBtnProductos().addActionListener(e ->
                JOptionPane.showMessageDialog(view, "Productos aún no implementado")
        );
    }
}
