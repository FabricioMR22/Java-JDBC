package JPA.dao;

import JPA.model.Producto;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    private EntityManager em;

    public ProductoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Producto producto){
        this.em.persist(producto);
    }

    public Producto read(Long id){
        return  em.find(Producto.class,id);
    }

    public List<Producto> read(){
        String query = "SELECT P FROM Producto AS P";
        return em.createQuery(query,Producto.class).getResultList();
    }

    public List<Producto> read(String nombre,String descripcion){
        String query = "SELECT P FROM Producto AS P WHERE P.nombre =: nombre OR P.descripcion=:descripcion ";
        Query querySelect = em.createQuery(query);
        querySelect.setParameter("nombre",nombre);
        querySelect.setParameter("descripcion",descripcion);

        return querySelect.getResultList();
    }
}
