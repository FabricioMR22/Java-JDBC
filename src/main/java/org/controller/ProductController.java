package controller;

import model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProductController {

    public void create() {
    }

    public void read() {
    }

    public void update() {
    }

    public void delete() {
    }

    public List<Producto> listar() throws SQLException {

        List<Producto> Productos = new ArrayList<>();

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost/control_de_stock?useTimeZone=true$serverTimeZone=UTC",
                "root",
                "Herlinda1?");

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

    public static void main(String[] args) {
        try {
            ProductController pro = new ProductController();

            pro.listar().forEach(producto ->
                    System.out.println( producto.getId() +" - "
                                    + producto.getNombre() + " - "
                                    + producto.getDescripcion() + " - "
                                    + producto.getCantidad()
                    )
            );
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
