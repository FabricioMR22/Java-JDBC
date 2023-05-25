package org.controller;

import factory.ConnectionFactory;
import org.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductController {

    public Integer create(Producto producto) throws SQLException{
        Connection con = new ConnectionFactory().recuperaConexion();
        con.setAutoCommit(false);

        PreparedStatement statement = con.prepareStatement(
                "INSERT INTO producto(nombre,descripcion,cantidad) VALUES (?,?,?);"
                ,Statement.RETURN_GENERATED_KEYS);

        int maximoCantidad = 50;
        int cantidad = producto.getCantidad();
        int resultSet = 0;

        try{
            do {
                int cantidadParaGuardar = Math.min(cantidad,maximoCantidad);
                producto.setCantidad(cantidadParaGuardar);
                resultSet = ejecutaRegistro(producto,statement);
                cantidad -= maximoCantidad;
            }while (cantidad>0);

            con.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            con.rollback();

        }

        statement.close();
        con.close();

        return resultSet;
    }

    private static Integer ejecutaRegistro(Producto producto, PreparedStatement statement) throws SQLException {
        statement.setString(1, producto.getNombre());
        statement.setString(2, producto.getDescripcion());
        statement.setInt(3, producto.getCantidad());

        if (producto.getCantidad()<50){
            throw new RuntimeException("Error registro");
        }

        statement.execute();

        ResultSet resultSet = statement.getGeneratedKeys();
        while (resultSet.next()){
            return resultSet.getInt(1);
        }
        return null;
    }

    public Producto read(Integer ID) throws SQLException {
        Connection con = new ConnectionFactory().recuperaConexion();
        PreparedStatement statement = con.prepareStatement(
                "SELECT * FROM producto WHERE id = ?;"
        );
        statement.setInt(1,ID);
        statement.execute();

        ResultSet resultSet = statement.getResultSet();

        Producto producto = new Producto();
        while (resultSet.next()){
            producto.setId(resultSet.getInt("id"));
            producto.setNombre(resultSet.getString("nombre"));
            producto.setDescripcion(resultSet.getString("descripcion"));
            producto.setCantidad(resultSet.getInt("cantidad"));
        }
        return producto;
    }

    public Integer update(Producto producto) throws SQLException {
        Connection con = new ConnectionFactory().recuperaConexion();
        PreparedStatement statement = con.prepareStatement(
                "UPDATE producto SET nombre = ?, descripcion = ?, cantidad = ? WHERE id = ?;"
        );
        statement.setString(1,producto.getNombre());
        statement.setString(2,producto.getDescripcion());
        statement.setInt(3,producto.getCantidad());
        statement.setInt(4,producto.getId());

        statement.execute();

        int CountMod = statement.getUpdateCount();
        con.close();

        return CountMod;
    }

    public Integer delete(Integer ID) throws SQLException{
        Connection con = new ConnectionFactory().recuperaConexion();
        PreparedStatement statement = con.prepareStatement(
                "DELETE FROM producto WHERE id = ?;"
        );

        statement.setInt(1,ID);
        statement.execute();

        int CountMod = statement.getUpdateCount();
        con.close();
        return CountMod;
    }

    public List<Producto> listar() throws SQLException {
        Connection con = new ConnectionFactory().recuperaConexion();

        List<Producto> Productos = new ArrayList<>();

        Statement statement = con.createStatement();
        statement.execute("SELECT * FROM producto;");
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
