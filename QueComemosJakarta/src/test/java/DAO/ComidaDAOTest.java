package DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import DAO_Interfaces.ComidaDAO;
import model.Comida;

public class ComidaDAOTest {

	private static ComidaDAO comidaDAO = DaoFactory.getComidaDAO();
	private static Comida comidaNueva;
	private static Comida comidaAModificar;
	private static Comida comidaABorrar;
	private static Comida comidaABuscar;

	@BeforeAll
	static void setUp() {
		comidaAModificar = new Comida("Milanesa", 200f);
		comidaDAO.persistir(comidaAModificar);
		comidaABorrar = new Comida("Fideos", 250f);
		comidaDAO.persistir(comidaABorrar);
		comidaABuscar = new Comida("Pizza", 300f);
		comidaDAO.persistir(comidaABuscar);
	}

	@Test
	public void testCrearComida() {
		comidaNueva = new Comida("Hamburguesa", 200f);
		comidaDAO.persistir(comidaNueva);
		Comida comidaDevuelta = comidaDAO.recuperar(comidaNueva.getId());
		assertNotNull(comidaDevuelta);
		assertEquals(comidaNueva.getNombre(), comidaDevuelta.getNombre());
		assertEquals(comidaNueva.getPrecio(), comidaDevuelta.getPrecio());
	}

	@Test
	public void testModificarComida() {
		comidaAModificar = comidaDAO.recuperar(comidaAModificar.getId());
		comidaAModificar.setNombre("Milanesa con pure");
		comidaDAO.actualizar(comidaAModificar);
		Comida comidaActualizada = comidaDAO.recuperar(comidaAModificar.getId());
		assertNotNull(comidaActualizada);
		assertEquals(comidaAModificar.getNombre(), comidaActualizada.getNombre());
		assertEquals(comidaAModificar.getPrecio(), comidaActualizada.getPrecio());
	}

	@Test
	public void testEliminarComida() {
		comidaDAO.borrar(comidaABorrar);
		Comida comidaBorrada = comidaDAO.recuperar(comidaABorrar.getId());
		assertNull(comidaBorrada);
	}

	@Test
	public void testBuscarComida() {
		Comida comidaBuscada = comidaDAO.recuperar(comidaABuscar.getId());
		assertNotNull(comidaBuscada);
		assertEquals(comidaABuscar.getNombre(), comidaBuscada.getNombre());
		assertEquals(comidaABuscar.getPrecio(), comidaBuscada.getPrecio());
	}

	@AfterAll
	static void tearDown() {
		comidaDAO.borrar(comidaNueva);
		comidaDAO.borrar(comidaAModificar);
		comidaDAO.borrar(comidaABuscar);
		comidaDAO.borrar(comidaABorrar);
	}
}
