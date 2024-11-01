package DAOHibernateJPA;

import model.Menu;

import org.hibernate.Hibernate;

import DAO_Interfaces.MenuDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class MenuDAOHibernateJPA extends GenericDAOHibernateJPA<Menu> implements MenuDAO {

	public MenuDAOHibernateJPA() {
		super(Menu.class);
	}

	@Override
	public void borrar(Menu entity) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			Menu menu = em.find(Menu.class, entity.getId());
			Hibernate.initialize(menu.getEstructura());

			em.remove(menu); // Eliminar el menu

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
}
