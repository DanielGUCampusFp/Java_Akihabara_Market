package com.akihabara.market.model;

public class ProductoOtaku {
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;

    // Constructor vacío
    public ProductoOtaku() {
    }

    // Constructor con parámetros
    public ProductoOtaku(String nombre, String categoria, double precio, int stock) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
    
    // Método toString sobrescrito
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Categoría: " + categoria + ", Precio: " + precio + ", Stock: " + stock + ".";
    }


}
