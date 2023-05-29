package JPA.dao;

import JPA.model.Producto;

import javax.persistence.EntityManager;

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
}
