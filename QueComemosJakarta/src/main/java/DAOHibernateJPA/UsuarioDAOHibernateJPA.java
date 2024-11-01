package DAOHibernateJPA;

import org.hibernate.Hibernate;

import DAO_Interfaces.GenericDAO;
import DAO_Interfaces.UsuarioDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import model.Usuario;

public class UsuarioDAOHibernateJPA extends GenericDAOHibernateJPA<Usuario> implements UsuarioDAO {

	public UsuarioDAOHibernateJPA() {
		super(Usuario.class);
	}

	@Override
	public Usuario obtenerPorEmail(String email) {
		EntityManager em = EMF.getEMF().createEntityManager();
		try {
			return em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class)
					.setParameter("email", email).getSingleResult();
		} catch (NoResultException e) {
			return null; // Si no encuentra ningún usuario con el email, devuelve null
		} finally {
			em.close();
		}
	}

	@Override
	public void borrar(Usuario entity) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			Usuario usuario = em.find(Usuario.class, entity.getId());
			Hibernate.initialize(usuario.getSugerencias());

			em.remove(usuario); // Eliminar el usuario

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
}
