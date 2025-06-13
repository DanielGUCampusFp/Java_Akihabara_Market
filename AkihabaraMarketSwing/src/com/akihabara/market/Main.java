package com.akihabara.market;

// Importación de la clase Controlador y la vista principal
import com.akihabara.market.controller.ControladorGUI;
import com.akihabara.market.view.VentanaPrincipal;

/**
 * Clase principal del proyecto. Inicia la aplicación Swing.
 */
public class Main {
    public static void main(String[] args) {
        // Asegura que la GUI se inicie en el hilo de eventos de Swing (buena práctica)
        javax.swing.SwingUtilities.invokeLater(() -> {
            // Crear una instancia de la ventana principal
            VentanaPrincipal vista = new VentanaPrincipal();

            // Crear el controlador y pasarle la vista
            new ControladorGUI(vista);

            // Mostrar la ventana
            vista.setVisible(true);
        });
    }
}
