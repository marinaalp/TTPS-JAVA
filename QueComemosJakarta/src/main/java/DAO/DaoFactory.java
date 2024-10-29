package DAO;

import DAO_Interfaces.RolDAO;
import DAO_Interfaces.UsuarioDAO;
import DAO_Interfaces.MenuDAO;
import DAO_Interfaces.ComidaDAO;
import DAO_Interfaces.PedidoDAO;
import DAO_Interfaces.SugerenciaDAO;

import DAOHibernateJPA.RolDAOHibernateJPA;
import DAOHibernateJPA.UsuarioDAOHibernateJPA;
import DAOHibernateJPA.MenuDAOHibernateJPA;
import DAOHibernateJPA.ComidaDAOHibernateJPA;
import DAOHibernateJPA.PedidoDAOHibernateJPA;
import DAOHibernateJPA.SugerenciaDAOHibernateJPA;


public class DaoFactory {
	
	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOHibernateJPA();
		}
	
	public static RolDAO getRolDAO() {
		return new RolDAOHibernateJPA();
	}
	
	public static MenuDAO getMenuDAO() {
		return new MenuDAOHibernateJPA();
	}
	
	public static ComidaDAO getComidaDAO() {
		return new ComidaDAOHibernateJPA();
	}
	
	public static PedidoDAO getPedidoDAO() {
		return new PedidoDAOHibernateJPA();
	}
	
	public static SugerenciaDAO getSugerenciaDAO() {
		return new SugerenciaDAOHibernateJPA();
	}
	

}