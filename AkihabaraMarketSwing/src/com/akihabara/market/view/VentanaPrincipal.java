package com.akihabara.market.view;

import javax.swing.*;  // Librerías Swing para ventanas, botones, tablas, etc.
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	// Campos de entrada de texto para el formulario
    public JTextField txtNombre = new JTextField(15);
    public JTextField txtCategoria = new JTextField(15);
    public JTextField txtPrecio = new JTextField(10);
    public JTextField txtStock = new JTextField(5);

    // Botones para agregar y listar productos
    public JButton btnAgregar = new JButton("Agregar");
    public JButton btnListar = new JButton("Listar");

    // Tabla para mostrar productos
    public JTable tablaProductos = new JTable();

    // Modelo de tabla: define columnas y permite añadir filas
    public DefaultTableModel modeloTabla;

    public VentanaPrincipal() {
        // Configuración básica de la ventana
        setTitle("Gestión de Productos Otaku");
        setSize(600, 400); // Ancho x Alto
        setLocationRelativeTo(null); // Centra la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Cierra aplicación al salir

        // === PANEL SUPERIOR: formulario ===
        JPanel panelFormulario = new JPanel(); // Usa FlowLayout por defecto
        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(txtNombre);
        panelFormulario.add(new JLabel("Categoría:"));
        panelFormulario.add(txtCategoria);
        panelFormulario.add(new JLabel("Precio:"));
        panelFormulario.add(txtPrecio);
        panelFormulario.add(new JLabel("Stock:"));
        panelFormulario.add(txtStock);
        panelFormulario.add(btnAgregar); // Botón "Agregar" al lado

        // === TABLA CENTRAL: productos ===
        modeloTabla = new DefaultTableModel(new String[]{"ID", "Nombre", "Categoría", "Precio", "Stock"}, 0);
        tablaProductos.setModel(modeloTabla);
        JScrollPane scroll = new JScrollPane(tablaProductos); // Scroll para tabla

        // === PANEL INFERIOR: botones adicionales ===
        JPanel panelInferior = new JPanel();
        panelInferior.add(btnListar);

        // === LAYOUT GENERAL: BorderLayout ===
        setLayout(new BorderLayout());
        add(panelFormulario, BorderLayout.NORTH);   // Formulario arriba
        add(scroll, BorderLayout.CENTER);           // Tabla al centro
        add(panelInferior, BorderLayout.SOUTH);     // Botón abajo
    }
}
