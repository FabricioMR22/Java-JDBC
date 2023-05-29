package JPA.prueba;

import JPA.model.Producto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class runProducto {
    public static void main(String[] args) {
        Producto producto = new Producto(
                "Samsung","Usado",new BigDecimal("199"));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tienda");
        EntityManager manager =  factory.createEntityManager();

        manager.persist(producto);
    }
}
