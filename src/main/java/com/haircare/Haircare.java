package com.haircare;

import com.haircare.conexion.Conexion;

public class Haircare {

    public static void main(String[] args) {

        // Probar conexión
        Conexion.conectar();

        // Probar CRUD
        ProductoDAO dao = new ProductoDAO();

        // INSERTAR
        Producto p = new Producto();
        p.setNombre("Shampoo Nutritivo");
        p.setDescripcion("Cabello seco");
        p.setPrecio(35000);
        p.setStock(10);

        dao.insertarProducto(p);

        // CONSULTAR
        System.out.println("=== LISTA DE PRODUCTOS ===");
        dao.listarProductos();

        // ACTUALIZAR
        p.setId(3);
        p.setNombre("Shampoo Reparador");
        p.setDescripcion("Cabello dañado");
        p.setPrecio(40000);
        p.setStock(15);

        dao.actualizarProducto(p);

        System.out.println("=== DESPUÉS DE ACTUALIZAR ===");
        dao.listarProductos();

        // ELIMINAR
        dao.eliminarProducto(4);

        System.out.println("=== DESPUÉS DE ELIMINAR ===");
        dao.listarProductos();
    }
}