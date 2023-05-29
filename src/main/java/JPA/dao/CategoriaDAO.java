package JPA.dao;

import JPA.model.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDAO {
    private EntityManager em;

    public CategoriaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Categoria categoria){
        this.em.persist(categoria);
    }

    public void actualizar(Categoria categoria){
        this.em.merge(categoria);
    }
}
