package JPA.prueba;

import JPA.dao.ClienteDAO;
import JPA.model.Cliente;
import JPA.utils.JPAUtils;

import javax.persistence.EntityManager;

public class runCliente {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtils.getEntityManager();

        ClienteDAO clienteDAO = new ClienteDAO(entityManager);

        Cliente cliente = new Cliente("Fabricio",202023);

        entityManager.getTransaction().begin();
        clienteDAO.save(cliente);
        entityManager.getTransaction().commit();
    }
}
