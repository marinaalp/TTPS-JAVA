package DAO;

import model.Rol;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import DAO_Interfaces.RolDAO;

public class RolDAOTest {
	private static RolDAO rolDAO = DaoFactory.getRolDAO();
	private static Rol rolNuevo;
	private static Rol rolAModificar;

	@BeforeAll
	static void setUp() {
		// Crear un rol de prueba que será modificado en otras pruebas
		rolAModificar = new Rol("USUARIO");
		rolDAO.persistir(rolAModificar);
	}

	@Test
	public void testCrearRol() {
		// Create a new Rol object with constructor arguments)
		rolNuevo = new Rol("ADMIN");
		rolDAO.persistir(rolNuevo);
		Rol rolDevuelto = rolDAO.obtenerPorNombre("ADMIN");
		assertNotNull(rolDevuelto);
		assertEquals(rolNuevo.getNombreRol(), rolDevuelto.getNombreRol());
	}

	@Test
	public void testModificarRol() {
		rolAModificar = rolDAO.obtenerPorNombre("USUARIO");
		rolAModificar.setNombreRol("USUARIO2");
		rolDAO.actualizar(rolAModificar);
		Rol rolActualizado = rolDAO.obtenerPorNombre(rolAModificar.getNombreRol());
		assertNotNull(rolActualizado);
		assertEquals(rolAModificar.getNombreRol(), rolActualizado.getNombreRol());
	}

	@Test
	public void testEliminarRol() {
		Rol encargado = new Rol("ENCARGADO");
		rolDAO.persistir(encargado);
		rolDAO.borrar(encargado);
		Rol rolBorrado = rolDAO.obtenerPorNombre(encargado.getNombreRol());
		assertNull(rolBorrado);
	}

	@Test
	public void testBuscarRol() {
		Rol rolBuscado = rolDAO.obtenerPorNombre("USUARIO");
		assertNotNull(rolBuscado);
		assertEquals(rolAModificar.getNombreRol(), rolBuscado.getNombreRol());
	}

	@AfterAll
	static void tearDown() {
		// Eliminar el rol creado en setUp
		rolDAO.borrar(rolAModificar);
		rolDAO.borrar(rolNuevo);
	}

}
