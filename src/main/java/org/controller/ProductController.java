package org.controller;

import factory.ConnectionFactory;
import org.DAO.ProductoDAO;
import org.model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductController {

    private ProductoDAO productoDAO;

    public ProductController() {
        this.productoDAO = new ProductoDAO(new ConnectionFactory().recuperaConexion());;
    }

    public void guardar(Producto producto, Integer categoriaId) {
        producto.setCategoriaId(categoriaId);
        this.productoDAO.create(producto);
    }

    public Producto buscar(Integer ID) {
        return this.productoDAO.read(ID);
    }

    public Integer actualizar(Producto producto)  {
        return this.productoDAO.update(producto);
    }

    public Integer borrar(Integer ID) {
        return this.productoDAO.delete(ID);
    }

    public List<Producto> listar() {
        return this.productoDAO.listar();
    }
}
