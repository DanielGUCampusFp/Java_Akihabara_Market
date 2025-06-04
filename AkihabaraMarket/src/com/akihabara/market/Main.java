package com.akihabara.market;

import com.akihabara.market.dao.ProductoDAO;
import com.akihabara.market.model.ProductoOtaku;
import com.akihabara.market.view.InterfazConsola;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InterfazConsola vista = new InterfazConsola();
        ProductoDAO dao = new ProductoDAO();
        boolean salir = false;

        while (!salir) {
            vista.mostrarMenu();
            int opcion = vista.leerOpcion();

            switch (opcion) {
                case 1:
                    ProductoOtaku nuevo = vista.pedirDatosProducto(false);
                    dao.agregarProducto(nuevo);
                    break;

                case 2:
                    int id = vista.pedirIdProducto();
                    ProductoOtaku producto = dao.obtenerProductoPorId(id);
                    if (producto != null) {
                        vista.mostrarMensaje(producto.toString());
                    } else {
                        vista.mostrarMensaje("Producto no encontrado.");
                    }
                    break;

                case 3:
                    List<ProductoOtaku> productos = dao.obtenerTodosLosProductos();
                    for (ProductoOtaku p : productos) {
                        vista.mostrarMensaje(p.toString());
                    }
                    break;

                case 4:
                    String nombre = vista.pedirNombreProducto();
                    List<ProductoOtaku> producto1 = dao.buscarProductosPorNombre(nombre);
                    for (ProductoOtaku p : producto1) {
                        vista.mostrarMensaje(p.toString());
                    }
                    break;

                case 5:
                    String categoria = vista.pedirCategoriaProducto();
                    List<ProductoOtaku> producto2 = dao.buscarProductoPorCategoria(categoria);
                    for (ProductoOtaku p : producto2) {
                        vista.mostrarMensaje(p.toString());
                    }
                    break;

                case 6:
                    ProductoOtaku actualizado = vista.pedirDatosProducto(true);
                    boolean ok = dao.actualizarProducto(actualizado);
                    if (ok) {
                        vista.mostrarMensaje("Producto actualizado correctamente.");
                    } else {
                        vista.mostrarMensaje("No se pudo actualizar el producto.");
                    }
                    break;

                case 7:
                    int idEliminar = vista.pedirIdProducto();
                    boolean eliminado = dao.eliminarProducto(idEliminar);
                    if (eliminado) {
                        vista.mostrarMensaje("Producto eliminado correctamente.");
                    } else {
                        vista.mostrarMensaje("No se pudo eliminar el producto.");
                    }
                    break;

                case 8:
                    vista.mostrarMensaje("Saliendo del programa...");
                    salir = true;
                    break;

                default:
                    vista.mostrarMensaje("Opción inválida.");
                    break;
            }
        }
    }
}
