package DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import DAO_Interfaces.ComidaDAO;
import DAO_Interfaces.EstructuraDAO;
import DAO_Interfaces.MenuDAO;
import model.Comida;
import model.Estructura;
import model.Menu;

public class MenuDAOTest {

	private static MenuDAO menuDAO = DaoFactory.getMenuDAO();
	private static Menu menuNuevo;
	private static Menu menuAModificar;
	private static Menu menuABorrar;
	private static Menu menuABuscar;
	private static EstructuraDAO estructuraDAO = DaoFactory.getEstructuraDAO();
	private static List<Estructura> estructura = new ArrayList<Estructura>();
	private static Estructura estructuraEntrada;
	private static Estructura estructuraPrincipal;
	private static Estructura estructuraPostre;
	private static Estructura estructuraBebida;
	private static ComidaDAO comidaDAO = DaoFactory.getComidaDAO();
	private static Comida comida;

	@BeforeAll
	static void setUp() {
		comida = new Comida("Milanesa", 200f);
		comidaDAO.persistir(comida);
		estructuraEntrada = new Estructura("entrada", List.of(comida));
		estructuraPrincipal = new Estructura("principal", List.of(comida));
		estructuraPostre = new Estructura("postre", List.of(comida));
		estructuraBebida = new Estructura("bebida", List.of(comida));
		estructura.add(estructuraEntrada);
		estructura.add(estructuraPrincipal);
		estructura.add(estructuraPostre);
		estructura.add(estructuraBebida);
		menuAModificar = new Menu("menu1", 380f, estructura);
		menuDAO.persistir(menuAModificar);
		menuABorrar = new Menu("menu2", 400f, estructura);
		menuDAO.persistir(menuABorrar);
		menuABuscar = new Menu("menu3", 450f, estructura);
		menuDAO.persistir(menuABuscar);

		estructuraDAO.persistir(estructuraEntrada);
		estructuraDAO.persistir(estructuraPrincipal);
		estructuraDAO.persistir(estructuraPostre);
		estructuraDAO.persistir(estructuraBebida);
	}

	@Test
	public void testCrearMenu() {
		menuNuevo = new Menu("menu4", 500f, estructura);
		menuDAO.persistir(menuNuevo);
		Menu menuDevuelto = menuDAO.recuperar(menuNuevo.getId());
		assertNotNull(menuDevuelto);
		assertEquals(menuNuevo.getNombre(), menuDevuelto.getNombre());
		assertEquals(menuNuevo.getPrecio(), menuDevuelto.getPrecio());
	}

	@Test
	public void testModificarMenu() {
		menuAModificar = menuDAO.recuperar(menuAModificar.getId());
		menuAModificar.setNombre("menu1 modificado");
		menuDAO.actualizar(menuAModificar);
		Menu menuActualizado = menuDAO.recuperar(menuAModificar.getId());
		assertNotNull(menuActualizado);
		assertEquals(menuAModificar.getNombre(), menuActualizado.getNombre());
		assertEquals(menuAModificar.getPrecio(), menuActualizado.getPrecio());
	}

	@Test
	public void testEliminarMenu() {
		menuDAO.borrar(menuABorrar);
		Menu menuBorrado = menuDAO.recuperar(menuABorrar.getId());
		assertNull(menuBorrado);
	}

	@Test
	public void testBuscarMenu() {
		Menu menuBuscado = menuDAO.recuperar(menuABuscar.getId());
		assertNotNull(menuBuscado);
		assertEquals(menuABuscar.getNombre(), menuBuscado.getNombre());
		assertEquals(menuABuscar.getPrecio(), menuBuscado.getPrecio());
	}

	@AfterAll
	static void tearDown() {
		menuDAO.borrar(menuNuevo);
		menuDAO.borrar(menuAModificar);
		menuDAO.borrar(menuABuscar);
		menuDAO.borrar(menuABorrar);
		estructuraDAO.borrar(estructuraEntrada);
		estructuraDAO.borrar(estructuraPrincipal);
		estructuraDAO.borrar(estructuraPostre);
		estructuraDAO.borrar(estructuraBebida);
		comidaDAO.borrar(comida);
	}

}
