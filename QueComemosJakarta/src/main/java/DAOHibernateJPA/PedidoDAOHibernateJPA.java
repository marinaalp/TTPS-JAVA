package DAOHibernateJPA;

import DAO_Interfaces.PedidoDAO;
import model.Pedido;

public class PedidoDAOHibernateJPA extends GenericDAOHibernateJPA<Pedido> implements PedidoDAO {

	public PedidoDAOHibernateJPA() {
		super(Pedido.class);
	}

	// Si necesitas algún método específico para Pedido, lo podés agregar aquí

}
