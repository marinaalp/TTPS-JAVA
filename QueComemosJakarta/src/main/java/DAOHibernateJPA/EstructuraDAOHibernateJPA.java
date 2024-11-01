package DAOHibernateJPA;


import DAO_Interfaces.EstructuraDAO;

import model.Estructura;

public class EstructuraDAOHibernateJPA extends GenericDAOHibernateJPA<Estructura> implements EstructuraDAO{

	public EstructuraDAOHibernateJPA() {
		super(Estructura.class);
		// TODO Auto-generated constructor stub
	}

}
