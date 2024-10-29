package DAOHibernateJPA;

import DAO_Interfaces.UsuarioDAO;
import jakarta.persistence.EntityManager;
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
}
