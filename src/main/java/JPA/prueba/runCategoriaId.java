package JPA.prueba;

import JPA.dao.CategoriaDAO;
import JPA.model.Categoria;
import JPA.model.CategoriaId;
import JPA.utils.JPAUtils;

import javax.persistence.EntityManager;

public class runCategoriaId {

    public static void main(String[] args) {
        EntityManager entityManager = JPAUtils.getEntityManager();
        CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);

        entityManager.getTransaction().begin();


        Categoria categoria = entityManager.find(Categoria.class,new CategoriaId("Celular","123"));
        System.out.println(categoria);
    }

}
