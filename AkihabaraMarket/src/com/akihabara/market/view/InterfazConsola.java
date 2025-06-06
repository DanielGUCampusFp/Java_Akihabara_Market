package com.akihabara.market.view;

import com.akihabara.market.model.ProductoOtaku;

import java.util.*;

public class InterfazConsola {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n=== Menú Principal ===");
        System.out.println("1. Añadir producto");
        System.out.println("2. Consultar producto por ID");
        System.out.println("3. Listar todos los productos");
        System.out.println("4. Buscar producto por nombre");
        System.out.println("5. Buscar producto por categoría");
        System.out.println("6. Actualizar producto");
        System.out.println("7. Eliminar producto");
        System.out.println("8. Añadir producto con nombre sugerido por IA");
        System.out.println("9. Salir");
        System.out.println("Selecciona una opción: ");
    }
    
    public int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Opción no válida. Intentelo de nuevo.");
            return -1;
        }
    }
    
    public ProductoOtaku pedirDatosProducto(boolean incluirID) {
        int id = 0;
        if (incluirID) {
            System.out.print("ID del producto: ");
            id = Integer.parseInt(scanner.nextLine());
        }
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Categoría: ");
        String categoria = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = Double.parseDouble(scanner.nextLine());
        System.out.print("Stock: ");
        int stock = Integer.parseInt(scanner.nextLine());

        	if (incluirID = true) {
        		return new ProductoOtaku(id, nombre, categoria, precio, stock);
        	} else {
        		return new ProductoOtaku(nombre, categoria, precio, stock);
        	}
                
                
    }
    
    public String pedirTipoProducto() {
        System.out.print("Categoría (Figura, Manga, Póster, Llavero, Ropa): ");
        return scanner.nextLine();
    }

    public String pedirFranquiciaProducto() {
        System.out.print("Introduce la franquicia del producto: ");
        return scanner.nextLine();
    }

    public String pedirPrecioProducto() {
        System.out.print("Introduce el precio del producto: ");
        return scanner.nextLine();
    }

    
    public int pedirIdProducto() {
        System.out.print("Introduce el ID del producto: ");
        return Integer.parseInt(scanner.nextLine());
    }
    
    public String pedirNombreProducto() {
    	System.out.print("Introduce el nombre del producto: ");
        return scanner.nextLine();
    }
    
    public String pedirCategoriaProducto() {
    	System.out.print("Introduce la categoría del producto: ");
        return scanner.nextLine();
    }
    
    public void mostrarMensaje(String mensaje) {
    	System.out.println(mensaje);
    }
    
    public ProductoOtaku pedirDatosProductoAPI(String nombreSugerido) {
        System.out.print("Categoría (Figura, Manga, Póster, Llavero, Ropa): ");
        String categoria = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = Double.parseDouble(scanner.nextLine());
        System.out.print("Stock: ");
        int stock = Integer.parseInt(scanner.nextLine());
        return new ProductoOtaku(nombreSugerido, categoria, precio, stock);
    }  
}