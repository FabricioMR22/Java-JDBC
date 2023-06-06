package JPA.prueba;

import JPA.dao.ProductoDAO;
import JPA.model.Pedido;
import JPA.model.Producto;
import JPA.model.items_pedido;
import JPA.utils.JPAUtils;

import javax.persistence.EntityManager;

public class runFetchPedido {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtils.getEntityManager();
        ProductoDAO productoDAO = new ProductoDAO(entityManager);


        items_pedido itemsPedido = entityManager.find(items_pedido.class,0l);

        System.out.println(itemsPedido);

        entityManager.close();


    }
}
