package vallegrade.edu.pe.controller;

import vallegrade.edu.pe.model.Cliente;
import vallegrade.edu.pe.service.ClienteService;
import vallegrade.edu.pe.view.ClientesView;

import javax.swing.*;

public class ClienteController {
    private ClientesView view;
    private ClienteService service;

    public ClienteController(ClientesView view, ClienteService service) {
        this.view = view;
        this.service = service;

        this.view.getBtnAgregar().addActionListener(e -> agregarCliente());
        this.view.getBtnEliminar().addActionListener(e -> eliminarCliente());
    }

    private void agregarCliente() {
        String nombre = view.getNombre();
        String telefono = view.getTelefono();

        if (nombre.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Debe llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente cliente = new Cliente(nombre, telefono);
        service.agregarCliente(cliente);
        view.agregarClienteTabla(nombre, telefono);
        view.limpiarCampos();
    }

    private void eliminarCliente() {
        int fila = view.getClienteSeleccionado();
        if (fila >= 0) {
            service.eliminarCliente(fila);
            view.eliminarClienteTabla(fila);
        } else {
            JOptionPane.showMessageDialog(view, "Seleccione un cliente para eliminar", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
}
