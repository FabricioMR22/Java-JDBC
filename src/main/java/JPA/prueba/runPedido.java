package JPA.prueba;

import JPA.dao.ClienteDAO;
import JPA.dao.PedidoDAO;
import JPA.dao.ProductoDAO;
import JPA.model.*;
import JPA.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class runPedido {
    public static void main(String[] args) {
        EntityManager manager = JPAUtils.getEntityManager();

        Cliente cliente = new Cliente("COMPRADOR RICO",72246072);


        ProductoDAO productoDAO = new ProductoDAO(manager);
        PedidoDAO pedidoDAO = new PedidoDAO(manager);
        ClienteDAO clienteDAO = new ClienteDAO(manager);


        pedidoDAO.relatorioVentas().forEach( relatorioVenta ->
                System.out.println(relatorioVenta));



    }
}
