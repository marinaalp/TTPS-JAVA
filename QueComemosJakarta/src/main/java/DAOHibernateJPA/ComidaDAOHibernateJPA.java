package DAOHibernateJPA;

import DAO_Interfaces.ComidaDAO;
import model.Comida;


public class ComidaDAOHibernateJPA extends GenericDAOHibernateJPA<Comida> implements ComidaDAO {

	public ComidaDAOHibernateJPA() {
		super(Comida.class);
	}

	// Si necesitas algún método específico para Comida, lo podés agregar aquí
}