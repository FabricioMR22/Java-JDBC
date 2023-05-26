package org.DAO;
import factory.ConnectionFactory;
import org.model.Producto;

import java.sql.*;

public class ProductoDAO {
    final private Connection con;

    public ProductoDAO(Connection con) {
        this.con = con;
    }

    public int create(Producto producto) throws SQLException{
        int resultSet = 0;

        try(con){
            con.setAutoCommit(false);

            final PreparedStatement statement = con.prepareStatement(
                    "INSERT INTO producto(nombre,descripcion,cantidad) VALUES (?,?,?);"
                    , Statement.RETURN_GENERATED_KEYS);

            try(statement) {
                int maximoCantidad = 50;
                int cantidad = producto.getCantidad();

                try {
                    do {
                        int cantidadParaGuardar = Math.min(cantidad, maximoCantidad);
                        producto.setCantidad(cantidadParaGuardar);
                        resultSet = ejecutaRegistro(producto, statement);
                        cantidad -= maximoCantidad;
                    } while (cantidad > 0);

                    con.commit();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    con.rollback();
                }
            }
        }

        return resultSet;
    }

    private static Integer ejecutaRegistro(Producto producto, PreparedStatement statement) throws SQLException {
        statement.setString(1, producto.getNombre());
        statement.setString(2, producto.getDescripcion());
        statement.setInt(3, producto.getCantidad());
        statement.execute();

        final ResultSet resultSet = statement.getGeneratedKeys();
        try(resultSet) {
            while (resultSet.next()){
                producto.setId(resultSet.getInt(1));
                System.out.println(String.format("Fue insertado el producto %s", producto));
                return resultSet.getInt(1);
            }
        }
        return 0;
    }

    public Producto read(Integer ID) throws SQLException {
        Producto producto = new Producto();

        try(con) {
            final PreparedStatement statement = con.prepareStatement(
                    "SELECT * FROM producto WHERE id = ?;"
            );

            try(statement) {
                statement.setInt(1, ID);
                statement.execute();
                extracted(producto, statement);
            }
        }
        return producto;
    }

    private static void extracted(Producto producto, PreparedStatement statement) throws SQLException {
        final ResultSet resultSet = statement.getResultSet();

        try(resultSet){
            while (resultSet.next()) {
                producto.setId(resultSet.getInt("id"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setDescripcion(resultSet.getString("descripcion"));
                producto.setCantidad(resultSet.getInt("cantidad"));
            }
        }
    }

    public Integer update(Producto producto) throws SQLException {
        try(con) {
            final PreparedStatement statement = con.prepareStatement(
                    "UPDATE producto SET nombre = ?, descripcion = ?, cantidad = ? WHERE id = ?;"
            );
            try(statement) {
                statement.setString(1,producto.getNombre());
                statement.setString(2,producto.getDescripcion());
                statement.setInt(3,producto.getCantidad());
                statement.setInt(4,producto.getId());
                statement.execute();

                return statement.getUpdateCount();
            }
        }
    }

    public Integer delete(Integer ID) throws SQLException{
        try(con){
            final PreparedStatement statement = con.prepareStatement(
                    "DELETE FROM producto WHERE id = ?;"
            );
            try(statement){
                statement.setInt(1,ID);
                statement.execute();
                return statement.getUpdateCount();
            }
        }
    }
}
