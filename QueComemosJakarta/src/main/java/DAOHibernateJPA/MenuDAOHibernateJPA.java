package DAOHibernateJPA;

import model.Menu;
import DAO_Interfaces.MenuDAO;

public class MenuDAOHibernateJPA extends GenericDAOHibernateJPA<Menu> implements MenuDAO {

	public MenuDAOHibernateJPA() {
		super(Menu.class);
	}

	// Si necesitas algún método específico para Menu, lo podés agregar aquí

}
