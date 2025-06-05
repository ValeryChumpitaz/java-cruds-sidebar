package vallegrade.edu.pe.controller;

import vallegrade.edu.pe.model.Producto;
import vallegrade.edu.pe.service.ProductoService;
import vallegrade.edu.pe.view.ProductoView;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ProductoController {
    private ProductoView view;
    private ProductoService service;

    public ProductoController(ProductoView view, ProductoService service) {
        this.view = view;
        this.service = service;

        // Cargar productos iniciales
        cargarProductos();

        // Botones
        view.getBtnAgregar().addActionListener(e -> agregarProducto());
        view.getBtnActualizar().addActionListener(e -> actualizarProducto());
        view.getBtnEliminar().addActionListener(e -> eliminarProducto());

        // Evento para seleccionar fila y mostrar datos en el formulario
        view.getTablaProductos().getSelectionModel().addListSelectionListener(e -> seleccionarProducto());
    }

    private void cargarProductos() {
        var modelo = view.getModeloTabla();
        modelo.setRowCount(0);
        for (Producto p : service.listarProductos()) {
            modelo.addRow(new Object[]{p.getId(), p.getNombre(), p.getDescripcion(), p.getPrecio()});
        }
    }

    private void agregarProducto() {
        try {
            String nombre = view.getTxtNombre().getText();
            String descripcion = view.getTxtDescripcion().getText();
            double precio = Double.parseDouble(view.getTxtPrecio().getText());

            if (nombre.isEmpty() || descripcion.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Por favor, complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Producto nuevo = new Producto();
            nuevo.setNombre(nombre);
            nuevo.setDescripcion(descripcion);
            nuevo.setPrecio(precio);

            service.agregarProducto(nuevo);
            cargarProductos();
            view.limpiarCampos();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Precio inválido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarProducto() {
        int fila = view.getTablaProductos().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(view, "Seleccione un producto para actualizar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            int id = (int) view.getModeloTabla().getValueAt(fila, 0);
            String nombre = view.getTxtNombre().getText();
            String descripcion = view.getTxtDescripcion().getText();
            double precio = Double.parseDouble(view.getTxtPrecio().getText());

            if (nombre.isEmpty() || descripcion.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Por favor, complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Producto actualizado = new Producto(id, nombre, descripcion, precio);
            service.actualizarProducto(actualizado);
            cargarProductos();
            view.limpiarCampos();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Precio inválido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarProducto() {
        int fila = view.getTablaProductos().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(view, "Seleccione un producto para eliminar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int id = (int) view.getModeloTabla().getValueAt(fila, 0);
        service.eliminarProducto(id);
        cargarProductos();
        view.limpiarCampos();
    }

    private void seleccionarProducto() {
        int fila = view.getTablaProductos().getSelectedRow();
        if (fila != -1) {
            String nombre = (String) view.getModeloTabla().getValueAt(fila, 1);
            String descripcion = (String) view.getModeloTabla().getValueAt(fila, 2);
            Double precio = (Double) view.getModeloTabla().getValueAt(fila, 3);

            view.getTxtNombre().setText(nombre);
            view.getTxtDescripcion().setText(descripcion);
            view.getTxtPrecio().setText(precio.toString());
        }
    }
}
