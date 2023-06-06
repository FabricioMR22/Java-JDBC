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
        //registro();
        EntityManager manager = JPAUtils.getEntityManager();

        ProductoDAO productoDAO = new ProductoDAO(manager);

        Producto productoConsultado = productoDAO.read(1l);
        System.out.println(productoConsultado.getNombre());

        productoDAO.read("Samsung","Usado")
                .forEach( producto -> System.out.println(producto));

        System.out.println(
                productoDAO.read("Xiaomi")
        );

    }

    private static void registro() {
        Categoria celulares = new Categoria("Celulares");
        Producto producto = new Producto(
                "Samsung",
                "Usado",
                new BigDecimal("199"),celulares);

        Producto producto2 = new Producto(
                "Xiaomi",
                "Nuevo",
                new BigDecimal("599"),celulares);

        Producto producto3 = new Producto(
                "iPhone",
                "Usado",
                new BigDecimal("300"),celulares);


        EntityManager manager = JPAUtils.getEntityManager();

        CategoriaDAO categoriaDAO = new CategoriaDAO(manager);
        ProductoDAO productoDAO = new ProductoDAO(manager);

        manager.getTransaction().begin();

        categoriaDAO.save(celulares);
        productoDAO.save(producto);
        productoDAO.save(producto2);
        productoDAO.save(producto3);

        manager.getTransaction().commit();
        manager.close();
    }
}
