package DAOHibernateJPA;

import DAO_Interfaces.SugerenciaDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Sugerencia;

public class SugerenciaDAOHibernateJPA extends GenericDAOHibernateJPA<Sugerencia> implements SugerenciaDAO {

	public SugerenciaDAOHibernateJPA() {
		super(Sugerencia.class);
	}
	
	@Override
	public void borrar(Sugerencia sugerencia) {
	    EntityManager em = EMF.getEMF().createEntityManager();
	    EntityTransaction tx = null;
	    try {
	        tx = em.getTransaction();
	        tx.begin();

	        // 1. Find the Sugerencia entity (optional)
	        Sugerencia suggestionToDelete = em.find(Sugerencia.class, sugerencia.getId());

	        // 2. Detach the Usuario (optional)
	        sugerencia.setUsuario(null);

	        // 3. Remove the Sugerencia
	        em.remove(em.merge(sugerencia));

	        tx.commit();
	    } catch (RuntimeException e) {
	        if (tx != null && tx.isActive()) {
	            tx.rollback();
	        }
	        throw e; // Log or handle the exception
	    } finally {
	        em.close();
	    }
	}

	// Métodos específicos para Sugerencia si es necesario
}
