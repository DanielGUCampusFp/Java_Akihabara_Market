package com.akihabara.market;

import com.akihabara.market.model.ProductoOtaku;

public class Main {
    public static void main(String[] args) {
        // Crear un producto de prueba
        ProductoOtaku producto = new ProductoOtaku("Figura de Goku", "Figuras", 29.99, 69);

        System.out.println(producto.toString());
    }
}

