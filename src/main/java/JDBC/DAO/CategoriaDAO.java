package JDBC.DAO;

import JDBC.model.Categoria;
import JDBC.model.Producto;

import java.sql.*;
import java.util.*;

public class CategoriaDAO {
    private Connection con;

    public CategoriaDAO(Connection con) {
        this.con = con;
    }

    public List<Categoria> listar() {
        List<Categoria> categorias = new ArrayList<>();

        try{
            var querySelet = "SELECT * FROM categoria";
            System.out.println(querySelet);

            final PreparedStatement statement = con.prepareStatement(querySelet);
            try(statement) {
                statement.execute();
                final ResultSet resultSet = statement.executeQuery();
                try(resultSet) {
                    while (resultSet.next()){
                        Categoria categoria = new Categoria(
                                resultSet.getInt("id"),
                                resultSet.getString("nombre")
                        );
                        categorias.add(categoria);
                    }
                }
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return categorias;
    }

    public List<Categoria> listarConProducto() {
        List<Categoria> listaCatProductos = new ArrayList<>();

        try{
            var querySelect = "SELECT C.id,C.nombre,P.id,P.nombre,P.cantidad FROM categoria C INNER JOIN producto P on C.id = P.categoria_id;";
            System.out.println(querySelect);

            final PreparedStatement statement = con.prepareStatement(querySelect);
            try(statement) {
                statement.execute();
                final ResultSet resultSet = statement.executeQuery();
                try(resultSet) {
                    while (resultSet.next()){
                        Integer categoriaId = resultSet.getInt("C.id");
                        String categoriaNombre = resultSet.getString("C.nombre");

                        var categoria = listaCatProductos
                                .stream()
                                .filter(cat -> cat.getId().equals(categoriaId))
                                .findAny().orElseGet( ()->{
                                   Categoria cat = new Categoria(categoriaId,categoriaNombre);

                                   listaCatProductos.add(cat);

                                   return cat;
                                });
                        Producto producto = new Producto(
                                resultSet.getString("P.nombre"),
                                resultSet.getInt("P.cantidad"));

                        categoria.agregarProducto(producto);
                    }
                }
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return listaCatProductos;
    }

}
