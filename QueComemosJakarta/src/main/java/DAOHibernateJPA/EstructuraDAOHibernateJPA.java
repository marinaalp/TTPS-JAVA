package DAOHibernateJPA;

import org.hibernate.Hibernate;

import DAO_Interfaces.EstructuraDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Estructura;

public class EstructuraDAOHibernateJPA extends GenericDAOHibernateJPA<Estructura> implements EstructuraDAO {

	public EstructuraDAOHibernateJPA() {
		super(Estructura.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void borrar(Estructura entity) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			Estructura estructura = em.find(Estructura.class, entity.getId());
			Hibernate.initialize(estructura.getComida());

			em.remove(estructura); // Eliminar la estructura

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

}
