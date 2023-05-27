package org.DAO;

import factory.ConnectionFactory;
import org.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    final private Connection con;

    private static final String UPDATE_PRODUCTO_QUERY = "UPDATE producto SET nombre = ?, descripcion = ?," +
            " cantidad = ?, categoria_id = ? WHERE id = ?;";
    private static final String DELETE_PRODUCTO_QUERY = "DELETE FROM producto WHERE id = ?;";

    private static final String LIST_PRODUCTO_QUERY = "SELECT * FROM producto;";

    public ProductoDAO(Connection con) {
        this.con = con;
    }

    public int create(Producto producto) {
        int resultSet = 0;

        String querySelect = "INSERT INTO producto(nombre,descripcion,cantidad,categoria_id) VALUES (?,?,?,?);";

        try (final PreparedStatement statement = con.prepareStatement(querySelect, Statement.RETURN_GENERATED_KEYS)) {


            try (statement) {
                resultSet = ejecutaRegistro(producto, statement);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return resultSet;
    }

    private static Integer ejecutaRegistro(Producto producto, PreparedStatement statement) throws SQLException {
        statement.setString(1, producto.getNombre());
        statement.setString(2, producto.getDescripcion());
        statement.setInt(3, producto.getCantidad());
        statement.setInt(4, producto.getCategoriaId());
        statement.execute();

        final ResultSet resultSet = statement.getGeneratedKeys();
        try (resultSet) {
            while (resultSet.next()) {
                producto.setId(resultSet.getInt(1));
                System.out.println(String.format("Fue insertado el producto %s", producto));
                return resultSet.getInt(1);
            }
        }
        return 0;
    }

    public Producto read(Integer ID) {
        Producto producto = new Producto();

        try {
            final PreparedStatement statement = con.prepareStatement(
                    "SELECT * FROM producto WHERE id = ?;"
            );

            try (statement) {
                statement.setInt(1, ID);
                statement.execute();
                extracted(producto, statement);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return producto;
    }

    private static void extracted(Producto producto, PreparedStatement statement) throws SQLException {
        final ResultSet resultSet = statement.getResultSet();

        try (resultSet) {
            while (resultSet.next()) {
                producto.setId(resultSet.getInt("id"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setDescripcion(resultSet.getString("descripcion"));
                producto.setCantidad(resultSet.getInt("cantidad"));
            }
        }
    }

    public Integer update(Producto producto) {
        try (final PreparedStatement statement = con.prepareStatement(UPDATE_PRODUCTO_QUERY);) {
            statement.setString(1, producto.getNombre());
            statement.setString(2, producto.getDescripcion());
            statement.setInt(3, producto.getCantidad());
            statement.setInt(4, producto.getId());
            statement.setInt(5, producto.getCategoriaId());
            statement.execute();

            return statement.getUpdateCount();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Error al actualizar producto", e);
        }
    }

    public Integer delete(Integer ID) {
        try (final PreparedStatement statement = con.prepareStatement(DELETE_PRODUCTO_QUERY);) {
            statement.setInt(1, ID);
            statement.execute();

            return statement.getUpdateCount();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public List<Producto> listar() {
        List<Producto> Productos = new ArrayList<>();

        try (final PreparedStatement statement = con.prepareStatement(LIST_PRODUCTO_QUERY)) {
            statement.execute();

            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Producto producto = new Producto(
                        resultSet.getString("nombre"),
                        resultSet.getString("descripcion"),
                        resultSet.getInt("cantidad")
                );
                Productos.add(producto);
            }

            return Productos;
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar productos",e);
        }
    }

    public List<Producto> listar(Integer categoriaId) {
        try {
            List<Producto> Productos = new ArrayList<>();
            var querySelet = "SELECT * FROM producto WHERE categoria_id = ?;";
            System.out.println(querySelet);

            final PreparedStatement statement = con.prepareStatement(querySelet);

            try (statement) {
                statement.setInt(1, categoriaId);
                statement.execute();
                final ResultSet resultSet = statement.getResultSet();

                try (resultSet) {
                    while (resultSet.next()) {
                        Producto producto = new Producto(
                                resultSet.getString("nombre"),
                                resultSet.getString("descripcion"),
                                resultSet.getInt("cantidad")
                        );
                        Productos.add(producto);
                    }
                }
                return Productos;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
