package org.DAO;

import org.model.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        List<Categoria> categorias = new ArrayList<>();

        try{
            var querySelect = "SELECT C.id,C.nombre,P.id,P.nombre,P.cantidad FROM categoria C INNER JOIN producto P on C.id = P.categoria_id;";
            System.out.println(querySelect);

            final PreparedStatement statement = con.prepareStatement(querySelect);
            try(statement) {
                statement.execute();
                final ResultSet resultSet = statement.executeQuery();
                try(resultSet) {
                    while (resultSet.next()){
                        int categoriaId = resultSet.getInt("id");
                        String categoriaNombre = resultSet.getString("nombre");

                        Categoria categoria =

                                new Categoria(
                                categoriaId,categoriaNombre
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

}
