
package DAOHibernateJPA;

import java.io.Serializable;
import java.util.List;

import DAO_Interfaces.GenericDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class GenericDAOHibernateJPA<T> implements GenericDAO<T> {
	protected Class<T> persistentClass;

	public GenericDAOHibernateJPA(Class<T> clase) {
		persistentClass = clase;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	@Override
	public T persistir(T entity) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(entity);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			throw e; // escribir en un log o mostrar un mensaje
		} finally {
			em.close();
		}
		return entity;
	}

	public T actualizar(T entity) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		T entityMerged = em.merge(entity);
		etx.commit();
		em.close();
		return entityMerged;
	}

	@Override
	public void borrar(T entity) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.merge(entity));
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			throw e; // escribir en un log o mostrar un mensaje
		} finally {
			em.close();
		}
	}

	@Override
	public T borrar(Long id) {
		EntityManager em = EMF.getEMF().createEntityManager();
		T entity = em.find(this.getPersistentClass(), id);
		if (entity != null) {
			em.remove(entity);
		}
		em.close();
		return entity;
	}

	@Override
	public boolean existe(Long id) {
		EntityManager em = EMF.getEMF().createEntityManager();
		T entity = em.find(this.getPersistentClass(), id);
		em.close();
		return entity != null;
	}

	@Override
	public T recuperar(Serializable id) {
		EntityManager em = EMF.getEMF().createEntityManager();
		T entity = em.find(this.getPersistentClass(), id);
		em.close();
		return entity;
	}

	public List<T> recuperarTodos(String columnOrder) {
		TypedQuery<T> consulta = EMF.getEMF().createEntityManager().createQuery(
				"select e from " + getPersistentClass().getSimpleName() + " e order by e." + columnOrder,
				persistentClass);

		List<T> resultado = consulta.getResultList();
		return resultado;
	}
}
