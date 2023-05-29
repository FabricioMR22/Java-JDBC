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

    public void update(Categoria categoria){
        this.em.merge(categoria);
    }

    public void delete(Categoria categoria){
        categoria = em.merge(categoria);
        this.em.remove(categoria);
    }
}
