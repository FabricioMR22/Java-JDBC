package JPA.prueba;

import JPA.dao.CategoriaDAO;
import JPA.model.Categoria;
import JPA.utils.JPAUtils;

import javax.persistence.EntityManager;

public class runCategoria {
    public static void main(String[] args) {
        EntityManager manager = JPAUtils.getEntityManager();

        CategoriaDAO categoriaDAO = new CategoriaDAO(manager);

        Categoria celulares = new Categoria("Celulares","123");

        manager.getTransaction().begin();
        categoriaDAO.save(celulares);

        Categoria categoria = manager.find(Categoria.class,1l);
        manager.remove(categoria);
        manager.flush();
    }
}
