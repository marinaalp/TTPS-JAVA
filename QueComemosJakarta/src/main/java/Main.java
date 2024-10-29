import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import DAOHibernateJPA.EMF;

public class Main {

	public static void main(String[] args) {
		
		
		  EntityManagerFactory emf =
		  Persistence.createEntityManagerFactory("unlp"); 
		  EntityManager em = emf.createEntityManager();
		  EntityTransaction etx = em.getTransaction();
		 
		
		/*EntityManager em = EMF.getEMF().createEntityManager();*/
		
		
		
		
		
	}
}