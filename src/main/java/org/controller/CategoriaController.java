package org.controller;

import factory.ConnectionFactory;
import org.DAO.CategoriaDAO;
import org.model.Categoria;

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
