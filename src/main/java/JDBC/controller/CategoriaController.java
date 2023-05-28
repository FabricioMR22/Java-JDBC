package JDBC.controller;

import JDBC.DAO.CategoriaDAO;
import JDBC.model.Categoria;
import JDBC.factory.ConnectionFactory;

import java.util.List;

public class CategoriaController {
    private CategoriaDAO categoriaDAO;

    public CategoriaController() {
        this.categoriaDAO = new CategoriaDAO(new ConnectionFactory().recuperaConexion());
    }

    public List<Categoria> listar(){
        return categoriaDAO.listar() ;
    }

    public List<Categoria> cargaReporte(){
        return categoriaDAO.listarConProducto() ;
    }

}
