package org.controller;

import factory.ConnectionFactory;
import org.DAO.ProductoDAO;
import org.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductController {

    private ProductoDAO productoDAO;

    public ProductController(ProductoDAO productoDAO) {
        this.productoDAO = new ProductoDAO(new ConnectionFactory().recuperaConexion());;
    }

    public void guardar(Producto producto) {
        ProductoDAO productoDAO = new ProductoDAO(new ConnectionFactory().recuperaConexion());
        productoDAO.create(producto);
    }

    public Producto buscar(Integer ID) throws SQLException {
        ProductoDAO productoDAO = new ProductoDAO(new ConnectionFactory().recuperaConexion());
        return productoDAO.read(ID);
    }

    public Integer actualizar(Producto producto) throws SQLException {
        ProductoDAO productoDAO = new ProductoDAO(new ConnectionFactory().recuperaConexion());
        return productoDAO.update(producto);
    }

    public Integer borrar(Integer ID) throws SQLException{
        ProductoDAO productoDAO = new ProductoDAO(new ConnectionFactory().recuperaConexion());
        return productoDAO.delete(ID);
    }

    public List<Producto> listar() throws SQLException {
        ProductoDAO productoDAO = new ProductoDAO(new ConnectionFactory().recuperaConexion());

        final Connection con = new ConnectionFactory().recuperaConexion();
        try(con) {
            List<Producto> Productos = new ArrayList<>();

            final Statement statement = con.createStatement();
            try(statement){
                statement.execute("SELECT * FROM producto;");

                extracted(Productos, statement);
                return Productos;
            }
        }
    }

    private static void extracted(List<Producto> Productos, Statement statement) throws SQLException {
        final ResultSet resultSet = statement.getResultSet();
        try(resultSet){
            while (resultSet.next()) {
                Producto producto = new Producto(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("descripcion"),
                        resultSet.getInt("cantidad")
                );
                Productos.add(producto);
            }
        }
    }
}
