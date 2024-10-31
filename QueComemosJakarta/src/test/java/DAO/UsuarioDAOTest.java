package DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import DAO_Interfaces.RolDAO;
import DAO_Interfaces.UsuarioDAO;
import model.Rol;
import model.Usuario;

public class UsuarioDAOTest {

	private static UsuarioDAO usuarioDAO = DaoFactory.getUsuarioDAO();
	private static RolDAO rolDAO = DaoFactory.getRolDAO();
	private static Rol rolAsignado;
	private static Usuario usuarioNuevo;
	private static Usuario usuarioAModificar;
	private static Usuario usuarioABorrar;
	private static Usuario usuarioABuscar;

	@BeforeAll
	static void setUp() {
		rolAsignado = new Rol("USUARIO");
		rolDAO.persistir(rolAsignado);
		usuarioAModificar = new Usuario("39543627", "Ana", "Perez", "a.pe@mimail.com", "1234", "imagen/foto",
				rolAsignado);
		usuarioDAO.persistir(usuarioAModificar);
		usuarioABorrar = new Usuario("39543634", "Pedro", "Gimenez", "p.gi@mimail.com", "1234", "imagen/foto",
				rolAsignado);
		usuarioDAO.persistir(usuarioABorrar);
		usuarioABuscar = new Usuario("39513635", "Santiago", "Baez", "s.ba@mimail.com", "1234", "imagen/foto",
				rolAsignado);
		usuarioDAO.persistir(usuarioABuscar);
	}

	@Test
	public void testCrearUsuario() {
		usuarioNuevo = new Usuario("39543620", "Betiana", "Lopez", "a.lo@mimail.com", "1234", "imagen/foto",
				rolAsignado);
		usuarioDAO.persistir(usuarioNuevo);
		Usuario usuarioRetorno = usuarioDAO.obtenerPorEmail(usuarioNuevo.getEmail());
		assertNotNull(usuarioRetorno);
		assertEquals(usuarioNuevo.getDni(), usuarioRetorno.getDni());
		assertEquals(usuarioNuevo.getNombre(), usuarioRetorno.getNombre());
		assertEquals(usuarioNuevo.getApellido(), usuarioRetorno.getApellido());
		assertEquals(usuarioNuevo.getEmail(), usuarioRetorno.getEmail());
	}

	@Test
	public void testModificarUsuario() {
		usuarioAModificar = usuarioDAO.recuperar(usuarioAModificar.getId());
		usuarioAModificar.setApellido("Gomez");
		usuarioDAO.actualizar(usuarioAModificar);
		Usuario usuarioActualizado = usuarioDAO.recuperar(usuarioAModificar.getId());
		assertNotNull(usuarioActualizado);
		assertEquals(usuarioAModificar.getDni(), usuarioActualizado.getDni());
		assertEquals(usuarioAModificar.getNombre(), usuarioActualizado.getNombre());
		assertEquals(usuarioAModificar.getApellido(), usuarioActualizado.getApellido());
		assertEquals(usuarioAModificar.getEmail(), usuarioActualizado.getEmail());
	}

	@Test
	public void testEliminarUsuario() {
		usuarioDAO.borrar(usuarioABorrar);
		Usuario usuarioBorrado = usuarioDAO.obtenerPorEmail(usuarioABorrar.getEmail());
		assertNull(usuarioBorrado);

	}

	@Test
	public void testBuscarUsuario() {
		Usuario usuarioBuscado = usuarioDAO.obtenerPorEmail(usuarioABuscar.getEmail());
		assertNotNull(usuarioBuscado);
		assertEquals(usuarioABuscar.getDni(), usuarioBuscado.getDni());
		assertEquals(usuarioABuscar.getNombre(), usuarioBuscado.getNombre());
		assertEquals(usuarioABuscar.getApellido(), usuarioBuscado.getApellido());
		assertEquals(usuarioABuscar.getEmail(), usuarioBuscado.getEmail());
	}

	@AfterAll
	static void tearDown() {
		usuarioDAO.borrar(usuarioAModificar);
		usuarioDAO.borrar(usuarioNuevo);
		usuarioDAO.borrar(usuarioABorrar);
		usuarioDAO.borrar(usuarioABuscar);
		rolDAO.borrar(rolAsignado);

	}

}
