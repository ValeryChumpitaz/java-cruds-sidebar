package vallegrade.edu.pe.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ProductosView extends JPanel {

    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextField txtCantidad;
    private JButton btnAgregar;
    private JButton btnEliminar;
    private JTable tablaProductos;
    private DefaultTableModel modeloTabla;

    public ProductosView() {
        setLayout(new BorderLayout());

        // Panel principal con margen
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(new EmptyBorder(15, 15, 15, 15));
        add(panelPrincipal);

        // Panel formulario (arriba)
        JPanel panelFormulario = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(20);

        JLabel lblPrecio = new JLabel("Precio:");
        txtPrecio = new JTextField(10);

        JLabel lblCantidad = new JLabel("Cantidad:");
        txtCantidad = new JTextField(5);

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
        panelFormulario.add(lblPrecio, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panelFormulario.add(txtPrecio, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panelFormulario.add(lblCantidad, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panelFormulario.add(txtCantidad, gbc);

        panelPrincipal.add(panelFormulario, BorderLayout.NORTH);

        // Panel botones (centro)
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        btnAgregar = new JButton("Agregar");
        btnEliminar = new JButton("Eliminar");

        btnAgregar.setIcon(UIManager.getIcon("FileChooser.newFolderIcon"));
        btnEliminar.setIcon(UIManager.getIcon("OptionPane.errorIcon"));

        btnAgregar.setFocusable(false);
        btnEliminar.setFocusable(false);

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);

        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        // Tabla (abajo)
        modeloTabla = new DefaultTableModel(new Object[]{"Nombre", "Precio", "Cantidad"}, 0);
        tablaProductos = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaProductos);

        panelPrincipal.add(scrollPane, BorderLayout.SOUTH);
    }

    // Métodos para interactuar con los campos y tabla

    public String getNombre() {
        return txtNombre.getText().trim();
    }

    public String getPrecio() {
        return txtPrecio.getText().trim();
    }

    public String getCantidad() {
        return txtCantidad.getText().trim();
    }

    public void limpiarCampos() {
        txtNombre.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
    }

    public void agregarProductoTabla(String nombre, String precio, String cantidad) {
        modeloTabla.addRow(new Object[]{nombre, precio, cantidad});
    }

    public int getProductoSeleccionado() {
        return tablaProductos.getSelectedRow();
    }

    public void eliminarProductoTabla(int index) {
        modeloTabla.removeRow(index);
    }

    // Getters botones para el controlador

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }
}
