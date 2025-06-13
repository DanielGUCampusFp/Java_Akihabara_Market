package com.akihabara.market.controller;

// Importación de las clases necesarias del modelo, DAO y vista
import com.akihabara.market.dao.ProductoDAO;
import com.akihabara.market.model.ProductoOtaku;
import com.akihabara.market.view.VentanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Clase ControladorGUI que actúa como controlador en el patrón MVC.
 * Gestiona la lógica entre la vista (Swing) y el modelo (DAO).
 */
public class ControladorGUI {
    private VentanaPrincipal vista; // Referencia a la ventana Swing (vista)
    private ProductoDAO dao;        // Acceso a la lógica de datos (modelo)

    // Constructor: recibe la vista, instancia el DAO y configura los listeners
    public ControladorGUI(VentanaPrincipal vista) {
        this.vista = vista;
        this.dao = new ProductoDAO();
        initListeners(); // Configura los eventos de los botones
    }

    // Método privado para registrar los eventos (listeners)
    private void initListeners() {
        // Evento para el botón "Agregar"
        vista.btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener datos del formulario
                String nombre = vista.txtNombre.getText();
                String categoria = vista.txtCategoria.getText();
                double precio = Double.parseDouble(vista.txtPrecio.getText());
                int stock = Integer.parseInt(vista.txtStock.getText());

                // Crear el objeto ProductoOtaku y agregarlo mediante el DAO
                ProductoOtaku nuevo = new ProductoOtaku(nombre, categoria, precio, stock);
                dao.agregarProducto(nuevo);

                // Limpiar campos y refrescar la tabla
                limpiarCampos();
                listarProductos();
            }
        });

        // Evento para el botón "Listar"
        vista.btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarProductos(); // Muestra todos los productos en la tabla
            }
        });
    }

    // Método que actualiza la tabla con todos los productos del DAO
    private void listarProductos() {
        List<ProductoOtaku> productos = dao.obtenerTodosLosProductos(); // Obtener lista

        // Limpiar la tabla antes de volver a cargarla
        vista.modeloTabla.setRowCount(0);

        // Añadir cada producto como una nueva fila
        for (ProductoOtaku p : productos) {
            vista.modeloTabla.addRow(new Object[]{
                p.getId(),
                p.getNombre(),
                p.getCategoria(),
                p.getPrecio(),
                p.getStock()
            });
        }
    }

    // Método que limpia los campos de texto del formulario
    private void limpiarCampos() {
        vista.txtNombre.setText("");
        vista.txtCategoria.setText("");
        vista.txtPrecio.setText("");
        vista.txtStock.setText("");
    }
}
