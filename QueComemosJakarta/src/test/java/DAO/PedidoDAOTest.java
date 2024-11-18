package DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import DAO_Interfaces.ComidaDAO;
import DAO_Interfaces.PedidoDAO;
import DAO_Interfaces.RolDAO;
import DAO_Interfaces.UsuarioDAO;
import model.Comida;
import model.Pedido;
import model.Rol;
import model.Usuario;

public class PedidoDAOTest {

	private static PedidoDAO pedidoDAO = DaoFactory.getPedidoDAO();
	private static RolDAO rolDAO = DaoFactory.getRolDAO();
	private static UsuarioDAO usuarioDAO = DaoFactory.getUsuarioDAO();
	private static ComidaDAO comidaDAO = DaoFactory.getComidaDAO();
	private static Rol rolAsignado;
	private static Usuario usuarioPedido;
	private static Comida comidaPedido;
	private static Comida comidaPedido2;
	private static Pedido pedidoNuevo;
	private static Pedido pedidoAModifcar;
	private static Pedido pedidoABorrar;
	private static List<Comida> comidas;
	
	/*
	 * @BeforeAll static void setUp() { comidas = new ArrayList<>(); rolAsignado =
	 * new Rol("USUARIO"); usuarioPedido = new Usuario("39543627", "Ana", "Perez",
	 * "a.pe@mimail.com", "1234", "imagen/foto", rolAsignado); comidaPedido = new
	 * Comida("Milanesa", 200f); comidaPedido2 = new Comida("Gaseosa", 50f);
	 * 
	 * comidas.add(comidaPedido); comidas.add(comidaPedido2);
	 * rolDAO.persistir(rolAsignado); usuarioDAO.persistir(usuarioPedido);
	 * comidaDAO.persistir(comidaPedido); comidaDAO.persistir(comidaPedido2); Date
	 * fecha = new Date(); // Pedido pedidoAModifcar = new Pedido(fecha, null,
	 * comidas, usuarioPedido); // Pedido pedidoABorrar = new Pedido(fecha, null,
	 * comidas, usuarioPedido); // pedidoDAO.persistir(pedidoAModifcar); //
	 * pedidoDAO.persistir(pedidoABorrar);
	 * 
	 * }
	 * 
	 * @Test public void testCrearPedido() { Date fecha = new Date(); //List<Menu>
	 * menus = new ArrayList<>(); //menus.add(new Menu("Menu Ejecutivo", 150f));
	 * 
	 * pedidoNuevo = new Pedido(fecha, null, comidas, usuarioPedido);
	 * assertEquals(250f, pedidoNuevo.getMonto(), 0.01);
	 * pedidoDAO.persistir(pedidoNuevo); Pedido pedidoRetorno =
	 * pedidoDAO.recuperar(pedidoNuevo.getId()); assertNotNull(pedidoRetorno);
	 * 
	 * }
	 * 
	 * public void testModificarPedido() {
	 * 
	 * }
	 * 
	 * 
	 * 
	 * public void testEliminarPedido() { // pedidoDAO.borrar(pedidoABorrar);
	 * 
	 * }
	 * 
	 * public void testBuscarPedido() {
	 * 
	 * 
	 * }
	 * 
	 * @AfterAll static void tearDown() { pedidoDAO.borrar(pedidoNuevo);
	 * comidaDAO.borrar(comidaPedido); comidaDAO.borrar(comidaPedido2);
	 * usuarioDAO.borrar(usuarioPedido); rolDAO.borrar(rolAsignado); }
	 */

}
