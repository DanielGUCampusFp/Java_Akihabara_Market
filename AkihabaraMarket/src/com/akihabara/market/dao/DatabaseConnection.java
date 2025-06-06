package com.akihabara.market.dao;

import java.sql.*;

/**
 * Clase que gestiona la conexión a la base de datos MySQL.
 */
public class DatabaseConnection {
	// Propiedad de conexión
    private Connection conexion;
	
    // Constantes para la conexión
    private static final String DB_URL = "jdbc:mysql://localhost:3306/akihabara_db"; // Nombre de la base de datos
    private static final String USER = "userAkihabara";
    private static final String PASSWORD = "curso";
    

    /**
     * Constructor: Carga el driver y establece la conexión.
     */
    public DatabaseConnection() {
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Se ha cargado en memoria el driver de MySQL.");

            // Establecer la conexión
            conexion = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Se ha establecido con éxito la conexión a la base de datos.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se pudo cargar el driver de MySQL.");
            System.out.println("Causa: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos.");
            System.out.println("Causa: " + e.getMessage());
        }
    }

    /**
     * Retorna la instancia de conexión activa.
     */
    public Connection getConexion() {
        return conexion;
    }

    /**
     * Cierra la conexión si está activa.
     */
    public void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Se ha cerrado la conexión con la base de datos.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión.");
                System.out.println("Causa: " + e.getMessage());
            }
        }
    }
}
