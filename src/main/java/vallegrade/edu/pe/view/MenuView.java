package vallegrade.edu.pe.view;

import javax.swing.*;
import java.awt.*;

public class MenuView extends JFrame {

    private JPanel panelSidebar;
    private JButton btnClientes;
    private JButton btnProductos;
    private JPanel panelContenido;

    public MenuView() {
        setTitle("Sistema de Gestión");
        setTitle("Sistema Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // <-- Aquí maximizamos
        setLocationRelativeTo(null); // <-- Opcional, centra la ventana

        // Layout principal
        setLayout(new BorderLayout());

        // Sidebar lateral (izquierda)
        panelSidebar = new JPanel();
        panelSidebar.setLayout(new BoxLayout(panelSidebar, BoxLayout.Y_AXIS));
        panelSidebar.setBackground(new Color(30, 30, 60));
        panelSidebar.setPreferredSize(new Dimension(200, getHeight()));

        JLabel lblTitulo = new JLabel("Menú");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        btnClientes = new JButton("Clientes");
        btnProductos = new JButton("Productos");

        configurarBotonSidebar(btnClientes);
        configurarBotonSidebar(btnProductos);

        panelSidebar.add(lblTitulo);
        panelSidebar.add(Box.createVerticalStrut(10));
        panelSidebar.add(btnClientes);
        panelSidebar.add(Box.createVerticalStrut(10));
        panelSidebar.add(btnProductos);

        add(panelSidebar, BorderLayout.WEST);

        // Panel de contenido (derecha)
        panelContenido = new JPanel(new BorderLayout());
        add(panelContenido, BorderLayout.CENTER);
    }

    private void configurarBotonSidebar(JButton boton) {
        boton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.setFocusPainted(false);
        boton.setBackground(new Color(50, 50, 100));
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.PLAIN, 16));
        boton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }

    // Métodos públicos para controladores
    public JButton getBtnClientes() {
        return btnClientes;
    }

    public JButton getBtnProductos() {
        return btnProductos;
    }

    public JPanel getPanelContenido() {
        return panelContenido;
    }
}
