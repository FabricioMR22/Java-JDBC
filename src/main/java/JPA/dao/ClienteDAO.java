package JPA.dao;

import JPA.model.Cliente;
import JPA.model.Pedido;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDAO {
    private EntityManager em;

    public ClienteDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Cliente cliente){
        this.em.persist(cliente);
    }

    public Cliente read(Long id){
        return  em.find(Cliente.class,id);
    }

    public List<Cliente> read(){
        String query = "SELECT P FROM Cliente AS P";
        return em.createQuery(query,Cliente.class).getResultList();
    }
}
