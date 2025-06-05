package vallegrade.edu.pe.service;

import vallegrade.edu.pe.model.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoService {
    private List<Producto> productos = new ArrayList<>();
    private int nextId = 1;

    public void agregarProducto(Producto producto) {
        producto.setId(nextId++);
        productos.add(producto);
        System.out.println("Producto agregado: " + producto.getNombre());
    }

    public List<Producto> listarProductos() {
        return productos;
    }

    public void eliminarProducto(int id) {
        productos.removeIf(p -> p.getId() == id);
        System.out.println("Producto eliminado con id: " + id);
    }

    public void actualizarProducto(Producto productoActualizado) {
        Optional<Producto> productoOpt = productos.stream()
                .filter(p -> p.getId() == productoActualizado.getId())
                .findFirst();

        if (productoOpt.isPresent()) {
            Producto producto = productoOpt.get();
            producto.setNombre(productoActualizado.getNombre());
            producto.setDescripcion(productoActualizado.getDescripcion());
            producto.setPrecio(productoActualizado.getPrecio());
            System.out.println("Producto actualizado: " + producto.getNombre());
        }
    }
}
