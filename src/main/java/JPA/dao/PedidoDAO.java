package JPA.dao;

import JPA.model.Pedido;

import javax.persistence.EntityManager;
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
}
