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
        registro();
        EntityManager manager = JPAUtils.getEntityManager();

        ProductoDAO productoDAO = new ProductoDAO(manager);

        Producto productoConsultado = productoDAO.read(1l);
        System.out.println(productoConsultado.getNombre());

    }

    private static void registro() {
        Categoria celulares = new Categoria("Celulares");
        Producto producto = new Producto(
                "Samsung",
                "Usado",
                new BigDecimal("199"),celulares);

        EntityManager manager = JPAUtils.getEntityManager();

        CategoriaDAO categoriaDAO = new CategoriaDAO(manager);
        ProductoDAO productoDAO = new ProductoDAO(manager);

        manager.getTransaction().begin();

        categoriaDAO.save(celulares);
        productoDAO.save(producto);

        manager.getTransaction().commit();
        manager.close();
    }
}
