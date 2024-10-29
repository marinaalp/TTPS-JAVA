package DAOHibernateJPA;

import DAO_Interfaces.RolDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import model.Rol;

public class RolDAOHibernateJPA extends GenericDAOHibernateJPA<Rol> implements RolDAO {

	public RolDAOHibernateJPA() {
		super(Rol.class);
	}

	@Override
	public Rol obtenerPorNombre(String nombreRol) {
		EntityManager em = EMF.getEMF().createEntityManager();
		try {
			return em.createQuery("SELECT r FROM Rol r WHERE r.nombreRol = :nombreRol", Rol.class)
					.setParameter("nombreRol", nombreRol).getSingleResult();
		} catch (NoResultException e) {
			return null; // Si no encuentra el rol, devuelve null
		} finally {
			em.close();
		}
	}
}
