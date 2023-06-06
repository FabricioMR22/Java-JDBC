package JPA.dao;

import JPA.model.Pedido;
import JPA.vo.RelatorioVenta;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
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

    public List<RelatorioVenta> relatorioVentas(){
        String queryJpql = "SELECT new JPA.vo.RelatorioVenta(producto.nombre, " +
                "SUM(item.cantidad), " +
                "MAX(pedido.FechaDeRegistro)) " +
                "FROM Pedido pedido " +
                "JOIN pedido.items item " +
                "JOIN item.producto producto " +
                "GROUP BY producto.nombre " +
                "ORDER BY SUM(item.cantidad) DESC";
        return em.createQuery(queryJpql,RelatorioVenta.class).getResultList();
    }
}
