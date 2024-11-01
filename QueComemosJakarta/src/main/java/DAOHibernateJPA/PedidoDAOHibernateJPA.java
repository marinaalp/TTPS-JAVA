package DAOHibernateJPA;

import java.util.ArrayList;
import java.util.List;

import DAO_Interfaces.PedidoDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Pedido;
import model.Comida;

public class PedidoDAOHibernateJPA extends GenericDAOHibernateJPA<Pedido> implements PedidoDAO {

	public PedidoDAOHibernateJPA() {
		super(Pedido.class);
	}
	

	@Override
	public void borrar(Pedido pedido) {
		EntityManager em = EMF.getEMF().createEntityManager();
	    EntityTransaction tx = em.getTransaction();
	    try {
	        tx.begin();

	        // Encuentra el Pedido en la base de datos
	        Pedido pedidoPersistido = em.find(Pedido.class, pedido.getId());

	        // Elimina las Comidas asociadas al Pedido
	        List<Comida> comidas = new ArrayList<>(pedidoPersistido.getComidas());
	        for (Comida comida : comidas) {
	            pedidoPersistido.getComidas().remove(comida);
	            em.remove(comida); // Elimina la Comida de la base de datos
	        }

	        // Elimina el Pedido
	        em.remove(pedidoPersistido);

	        tx.commit();
	    } catch (Exception e) {
	        if (tx.isActive()) {
	            tx.rollback();
	        }
	        throw e;
	    } finally {
	        em.close();
	    }
	}

	// Si necesitas algún método específico para Pedido, lo podés agregar aquí

}
