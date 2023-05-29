package JPA.prueba;

import JPA.dao.CategoriaDAO;
import JPA.dao.ProductoDAO;
import JPA.model.Categoria;
import JPA.model.Producto;
import JPA.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class runProducto {
    public static void main(String[] args) {
        Categoria celulares = new Categoria("Celulares");

        Producto producto = new Producto(
                "Samsung",
                "Usado",
                new BigDecimal("199"),celulares);


        EntityManager manager = JPAUtils.getEntityManager();

        CategoriaDAO categoriaDAO = new CategoriaDAO(manager);

        manager.getTransaction().begin();

        categoriaDAO.save(celulares);
        celulares.setNombre("Libros");

        manager.flush();
        manager.clear();

        celulares = manager.merge(celulares);
        celulares.setNombre("Software");

        manager.flush();
    }
}
