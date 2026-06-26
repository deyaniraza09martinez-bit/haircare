package com.haircare;

import java.sql.*;

public class ProductoDAO {

    private String url = "jdbc:mysql://localhost:3306/haircare";
    private String user = "root";
    private String password = "";

    // INSERTAR
    public void insertarProducto(Producto producto) {

        String sql = "INSERT INTO productos (nombre, descripcion, precio, stock) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());

            ps.executeUpdate();
            System.out.println("Producto insertado");

        } catch (SQLException e) {
            System.out.println("Error insertar: " + e.getMessage());
        }
    }

    // CONSULTAR
    public void listarProductos() {

        String sql = "SELECT * FROM productos";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("nombre") + " | " +
                        rs.getString("descripcion") + " | " +
                        rs.getDouble("precio") + " | " +
                        rs.getInt("stock")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error listar: " + e.getMessage());
        }
    }

    // ACTUALIZAR
    public void actualizarProducto(Producto producto) {

        String sql = "UPDATE productos SET nombre=?, descripcion=?, precio=?, stock=? WHERE id=?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.setInt(5, producto.getId());

            ps.executeUpdate();
            System.out.println("Producto actualizado");

        } catch (SQLException e) {
            System.out.println("Error actualizar: " + e.getMessage());
        }
    }

    // ELIMINAR
    public void eliminarProducto(int id) {

        String sql = "DELETE FROM productos WHERE id=?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Producto eliminado");

        } catch (SQLException e) {
            System.out.println("Error eliminar: " + e.getMessage());
        }
    }
}