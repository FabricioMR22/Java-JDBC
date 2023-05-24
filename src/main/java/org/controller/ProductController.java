package org.controller;

import factory.ConnectionFactory;
import org.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductController {

    public Integer create(Producto producto) throws SQLException{
        Connection con = new ConnectionFactory().recuperaConexion();
        Statement statement = con.createStatement();

        statement.execute(
                "INSERT INTO producto(nombre,descripcion,cantidad)" +
                        " VALUES('"+producto.getNombre() + "','"
                        +producto.getDescripcion()+"',"
                        +producto.getCantidad()+");"
        ,Statement.RETURN_GENERATED_KEYS);

        ResultSet resultSet = statement.getGeneratedKeys();
        while (resultSet.next()){
            return resultSet.getInt(1);
        }
        return null;
    }

    public void read() {
    }

    public void update() {
    }

    public void delete(Integer ID) throws SQLException{
        Connection con = new ConnectionFactory().recuperaConexion();
        Statement statement = con.createStatement();

        statement.execute("DELETE FROM producto WHERE id = "+ ID);

        System.out.println("Registro mod =" + statement.getUpdateCount());

    }

    public List<Producto> listar() throws SQLException {
        Connection con = new ConnectionFactory().recuperaConexion();

        List<Producto> Productos = new ArrayList<>();

        Statement statement = con.createStatement();
        statement.execute("SELECT * FROM PRODUCTO");
        ResultSet resultSet = statement.getResultSet();

        while (resultSet.next()) {
            Producto producto = new Producto(
                    resultSet.getInt("id"),
                    resultSet.getString("nombre"),
                    resultSet.getString("descripcion"),
                    resultSet.getInt("cantidad")
            );
            Productos.add(producto);
        }

        con.close();
        return Productos;
    }

}
