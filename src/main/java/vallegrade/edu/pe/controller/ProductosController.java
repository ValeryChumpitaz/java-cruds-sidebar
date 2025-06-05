package vallegrade.edu.pe.controller;

import vallegrade.edu.pe.view.ProductosView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductosController {

    private ProductosView view;

    public ProductosController(ProductosView view) {
        this.view = view;
        initController();
    }

    private void initController() {
        view.getBtnAgregar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarProducto();
            }
        });

        view.getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarProducto();
            }
        });
    }

    private void agregarProducto() {
        String nombre = view.getNombre();
        String precioStr = view.getPrecio();
        String cantidadStr = view.getCantidad();

        // Validaciones básicas
        if (nombre.isEmpty() || precioStr.isEmpty() || cantidadStr.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar que precio y cantidad sean números
        double precio;
        int cantidad;
        try {
            precio = Double.parseDouble(precioStr);
            cantidad = Integer.parseInt(cantidadStr);
            if (precio < 0 || cantidad < 0) {
                JOptionPane.showMessageDialog(view, "Precio y cantidad deben ser valores positivos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Precio debe ser un número decimal y cantidad un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Agregar a la tabla
        view.agregarProductoTabla(nombre, String.format("%.2f", precio), String.valueOf(cantidad));
        view.limpiarCampos();
    }

    private void eliminarProducto() {
        int filaSeleccionada = view.getProductoSeleccionado();
        if (filaSeleccionada >= 0) {
            int confirm = JOptionPane.showConfirmDialog(view, "¿Está seguro de eliminar el producto seleccionado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                view.eliminarProductoTabla(filaSeleccionada);
            }
        } else {
            JOptionPane.showMessageDialog(view, "Por favor, seleccione un producto para eliminar.", "Información", JOptionPane.WARNING_MESSAGE);
        }
    }
}
