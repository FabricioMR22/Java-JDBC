package JPA.dao;

import JPA.model.Producto;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;
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
        Query querySelect = em.createQuery(query,Producto.class);
        querySelect.setParameter("nombre",nombre);
        querySelect.setParameter("descripcion",descripcion);

        return querySelect.getResultList();
    }

    public BigDecimal read(String nombre){
        return em.createNamedQuery("Producto.consultaPrecio", BigDecimal.class)
                .setParameter("nombre",nombre).getSingleResult();
    }

    public Producto consultaProductoCategoria(Long id){
        String jpql = "SELECT p FROM Producto p JOIN Fetch p.categoria WHERE p.id=:id";
        return em.createQuery(jpql,Producto.class).setParameter("id",id).getSingleResult();
    }
}
