package com.akihabara.market;

import com.akihabara.market.dao.DatabaseConnection;

/**
 * Clase temporal para probar la conexión a la base de datos.
 */
public class Main {
    public static void main(String[] args) {
        // Crear instancia para establecer conexión
        DatabaseConnection dbConn = new DatabaseConnection();

        // Cerrar la conexión
        dbConn.cerrarConexion();
    }
}
