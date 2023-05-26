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
            final PreparedStatement statement = con.prepareStatement("SELECT * FROM categoria");
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
}
