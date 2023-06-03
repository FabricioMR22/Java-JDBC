package JPA.prueba;

import JPA.dao.ClienteDAO;
import JPA.dao.PedidoDAO;
import JPA.dao.ProductoDAO;
import JPA.model.*;
import JPA.utils.JPAUtils;

import javax.persistence.EntityManager;

public class runPedido {
    public static void main(String[] args) {
        EntityManager manager = JPAUtils.getEntityManager();

        Cliente cliente = new Cliente("Fabricio",72246072);
        Cliente cliente2 = new Cliente("Fabricio2",72246072);


        ProductoDAO productoDAO = new ProductoDAO(manager);
        PedidoDAO pedidoDAO = new PedidoDAO(manager);
        ClienteDAO clienteDAO = new ClienteDAO(manager);


        manager.getTransaction().begin();

        clienteDAO.save(cliente);
        clienteDAO.save(cliente2);
        Pedido pedido = new Pedido(cliente2);

        Producto producto = productoDAO.read(1l);
        items_pedido productos = new items_pedido(5,producto,pedido);

        pedido.agregarItems(productos);

        pedidoDAO.save(pedido);

        manager.getTransaction().commit();
    }
}
