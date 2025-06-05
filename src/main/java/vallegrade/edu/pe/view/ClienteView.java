package vallegrade.edu.pe.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ClienteView extends JFrame {
    private JTextField txtNombre;
    private JTextField txtTelefono;
    private JButton btnAgregar;
    private JButton btnEliminar;
    private JTable tablaClientes;
    private DefaultTableModel modeloTabla;

    public ClienteView() {
        setTitle("Gestión de Clientes - Aplicación MVC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 450);
        setLocationRelativeTo(null); // Centrar ventana

        // Panel principal con margen
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(new EmptyBorder(15, 15, 15, 15));
        setContentPane(panelPrincipal);

        // Panel formulario (arriba)
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(20);
        JLabel lblTelefono = new JLabel("Teléfono:");
        txtTelefono = new JTextField(15);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panelFormulario.add(lblNombre, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panelFormulario.add(txtNombre, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panelFormulario.add(lblTelefono, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panelFormulario.add(txtTelefono, gbc);

        panelPrincipal.add(panelFormulario, BorderLayout.NORTH);

        // Panel botones (centro)
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        btnAgregar = new JButton("Agregar");
        btnEliminar = new JButton("Eliminar");

        // Agregar iconos simples
        btnAgregar.setIcon(UIManager.getIcon("FileChooser.newFolderIcon"));
        btnEliminar.setIcon(UIManager.getIcon("OptionPane.errorIcon"));

        btnAgregar.setFocusable(false);
        btnEliminar.setFocusable(false);

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);

        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        // Tabla (abajo)
        modeloTabla = new DefaultTableModel(new Object[]{"Nombre", "Teléfono"}, 0);
        tablaClientes = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaClientes);

        panelPrincipal.add(scrollPane, BorderLayout.SOUTH);
    }

    // Métodos para interactuar con los campos y tabla

    public String getNombre() {
        return txtNombre.getText().trim();
    }

    public String getTelefono() {
        return txtTelefono.getText().trim();
    }

    public void limpiarCampos() {
        txtNombre.setText("");
        txtTelefono.setText("");
    }

    public void agregarClienteTabla(String nombre, String telefono) {
        modeloTabla.addRow(new Object[]{nombre, telefono});
    }

    public int getClienteSeleccionado() {
        return tablaClientes.getSelectedRow();
    }

    public void eliminarClienteTabla(int index) {
        modeloTabla.removeRow(index);
    }

    // Getters botones para el controller

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }
}
