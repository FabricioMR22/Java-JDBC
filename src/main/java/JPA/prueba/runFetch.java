package JPA.prueba;

import JPA.dao.ProductoDAO;
import JPA.model.Pedido;
import JPA.model.Producto;
import JPA.utils.JPAUtils;

import javax.persistence.EntityManager;

public class runFetch {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtils.getEntityManager();
        ProductoDAO productoDAO = new ProductoDAO(entityManager);

        Pedido pedido = entityManager.find(Pedido.class,5l);
        Producto producto = productoDAO.consultaProductoCategoria(3l);


        entityManager.close();
        System.out.println(producto.getCategoria());


    }
}
