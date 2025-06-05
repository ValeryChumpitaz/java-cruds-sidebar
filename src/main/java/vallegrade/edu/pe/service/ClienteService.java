package vallegrade.edu.pe.service;

import vallegrade.edu.pe.model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente agregado: " + cliente.getNombre() + " - " + cliente.getTelefono());
    }

    public void eliminarCliente(int index) {
        if (index >= 0 && index < clientes.size()) {
            clientes.remove(index);
        }
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }
}
