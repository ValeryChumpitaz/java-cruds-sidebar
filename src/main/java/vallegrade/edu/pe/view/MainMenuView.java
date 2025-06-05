package vallegrade.edu.pe.view;

import javax.swing.*;
import java.awt.*;

public class MainMenuView extends JFrame {
    private JButton btnClientes;
    private JButton btnProductos;
    private JPanel panelPrincipal;

    public MainMenuView() {
        setTitle("Sistema de Gestión - Menú Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Sidebar
        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(60, 63, 65));
        sidebar.setLayout(new GridLayout(5, 1, 10, 10));
        sidebar.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        btnClientes = new JButton("Clientes");
        btnProductos = new JButton("Productos");

        configurarBoton(btnClientes);
        configurarBoton(btnProductos);

        sidebar.add(btnClientes);
        sidebar.add(btnProductos);

        // Panel Principal
        panelPrincipal = new JPanel();
        panelPrincipal.setBackground(Color.WHITE);
        panelPrincipal.setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Bienvenido al Sistema", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        panelPrincipal.add(titulo, BorderLayout.CENTER);

        // Añadir al frame
        add(sidebar, BorderLayout.WEST);
        add(panelPrincipal, BorderLayout.CENTER);
    }

    private void configurarBoton(JButton boton) {
        boton.setFocusPainted(false);
        boton.setBackground(new Color(75, 110, 175));
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        boton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }

    public JButton getBtnClientes() {
        return btnClientes;
    }

    public JButton getBtnProductos() {
        return btnProductos;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}
