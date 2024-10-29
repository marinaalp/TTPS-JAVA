package DAOHibernateJPA;

import DAO_Interfaces.SugerenciaDAO;
import model.Sugerencia;

public class SugerenciaDAOHibernateJPA extends GenericDAOHibernateJPA<Sugerencia> implements SugerenciaDAO {

	public SugerenciaDAOHibernateJPA() {
		super(Sugerencia.class);
	}

	// Métodos específicos para Sugerencia si es necesario
}
