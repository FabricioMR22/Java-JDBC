package JPA.prueba;

import JPA.dao.ProductoDAO;
import JPA.model.Producto;
import JPA.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class runProducto {
    public static void main(String[] args) {
        Producto producto = new Producto(
                "Samsung","Usado",new BigDecimal("199"));


        EntityManager manager = JPAUtils.getEntityManager();

        ProductoDAO productoDAO = new ProductoDAO(manager);

        manager.getTransaction().begin();

        productoDAO.save(producto);

        manager.getTransaction().commit();
        manager.close();
    }
}
