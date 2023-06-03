package JPA.dao;

import JPA.model.Pedido;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PedidoDAO {
    private EntityManager em;

    public PedidoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Pedido pedido){
        this.em.persist(pedido);
    }

    public Pedido read(Long id){
        return  em.find(Pedido.class,id);
    }

    public List<Pedido> read(){
        String query = "SELECT P FROM Pedido AS P";
        return em.createQuery(query,Pedido.class).getResultList();
    }

    public BigDecimal valorTotalVendido(){
        String queryJPQL = "SELECT SUM(p.valorTotal) FROM Pedido p";
        return em.createQuery(queryJPQL,BigDecimal.class).getSingleResult();
    }

    public List<Object[]> relatorioVentas(){
        String queryJpql = "SELECT producto.nombre, SUM(item.cantidad), MAX(pedido.FechaDeRegistro) " +
                "FROM Pedido pedido " +
                "JOIN pedido.items item " +
                "JOIN item.producto producto " +
                "GROUP BY producto.nombre, item.cantidad " +
                "ORDER BY item.cantidad DESC";
        return em.createQuery(queryJpql,Object[].class).getResultList();
    }
}
