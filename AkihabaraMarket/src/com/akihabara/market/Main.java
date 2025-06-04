package com.akihabara.market;

import com.akihabara.market.dao.ProductoDAO;
import com.akihabara.market.model.ProductoOtaku;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductoDAO dao = new ProductoDAO();

        // 1. Agregar producto
        ProductoOtaku nuevo = new ProductoOtaku("Figura de Naruto", "Figuras", 39.99, 20);
        dao.agregarProducto(nuevo);

        // 2. Obtener por ID
        ProductoOtaku encontrado = dao.obtenerProductoPorId(1);
        System.out.println("Producto con ID 1: " + encontrado);

        // 3. Obtener todos
        List<ProductoOtaku> productos = dao.obtenerTodosLosProductos();
        System.out.println("Todos los productos:");
        for (ProductoOtaku p : productos) {
            System.out.println(p);
        }

        // 4. Buscar por nombre
        List<ProductoOtaku> porNombre = dao.buscarProductosPorNombre("Naruto");
        System.out.println("Búsqueda por nombre:");
        porNombre.forEach(System.out::println);

        // 5. Buscar por categoría
        List<ProductoOtaku> porCategoria = dao.buscarProductoPorCategoria("Figura");
        System.out.println("Búsqueda por categoría:");
        porCategoria.forEach(System.out::println);

        // 6. Actualizar producto
        ProductoOtaku actualizar = new ProductoOtaku(1, "SISIISISIS", "Figura", 0, 0);
        dao.actualizarProducto(actualizar);

        // 7. Eliminar producto
        dao.eliminarProducto(2);
    }
}
