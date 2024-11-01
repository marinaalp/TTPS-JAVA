package DAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import DAO_Interfaces.RolDAO;
import DAO_Interfaces.SugerenciaDAO;
import DAO_Interfaces.UsuarioDAO;
import model.Rol;
import model.Sugerencia;
import model.Usuario;

public class SugerenciaDAOTest {

	private static SugerenciaDAO sugerenciaDAO = DaoFactory.getSugerenciaDAO();
	private static RolDAO rolDAO = DaoFactory.getRolDAO();
	private static UsuarioDAO usuarioDAO = DaoFactory.getUsuarioDAO();
	private static Rol rolAsignado;
	private static Usuario usuarioNuevo;
	private static Sugerencia sugerenciaNueva;
	private static Sugerencia sugerenciaAModificar;
	private static Sugerencia sugerenciaABorrar;
	private static Sugerencia sugerenciaABuscar;
	static List<String> tipos = new ArrayList<>();

	@BeforeAll
	static void setUp() {
		tipos.add("alimentos");
		tipos.add("infraestructura");
		tipos.add("atención");
		rolAsignado = new Rol("USUARIO2");
		rolDAO.persistir(rolAsignado);
		usuarioNuevo = new Usuario("32243627", "Manuel", "Perez", "m.pe@mimail.com", "1234", "imagen/foto",
				rolAsignado);
		usuarioDAO.persistir(usuarioNuevo);
		Date fecha = new Date();
		sugerenciaAModificar = new Sugerencia(tipos.get(1), "las sillas son incomodas", fecha, usuarioNuevo);
		sugerenciaDAO.persistir(sugerenciaAModificar);
		sugerenciaABorrar = new Sugerencia(tipos.get(2), "los precios no se ven bien", fecha, usuarioNuevo);
		sugerenciaDAO.persistir(sugerenciaABorrar);
		sugerenciaABuscar = new Sugerencia(tipos.get(1), "agreguen aire acondicionado", fecha, usuarioNuevo);
		sugerenciaDAO.persistir(sugerenciaABuscar);

	}

	@Test
	public void testCrearSugerencia() {
		// Crear una fecha específica (por ejemplo, 2023-11-24)
		LocalDate fechaEspecifica = LocalDate.of(2023, 11, 24);
		Date fechaParaSugerencia = java.sql.Date.valueOf(fechaEspecifica);
		sugerenciaNueva = new Sugerencia(tipos.get(0), "le faltaba sal", fechaParaSugerencia, usuarioNuevo);
		sugerenciaDAO.persistir(sugerenciaNueva);
		Sugerencia sugerenciaDevuelta = sugerenciaDAO.recuperar(sugerenciaNueva.getId());
		assertNotNull(sugerenciaDevuelta);
		assertEquals(sugerenciaNueva.getDescripcion(), sugerenciaDevuelta.getDescripcion());

	}

	@Test
	public void testModificarSugerencia() {
		sugerenciaAModificar = sugerenciaDAO.recuperar(sugerenciaAModificar.getId());
		sugerenciaAModificar.setDescripcion("necesita mayor ventilacion");
		sugerenciaDAO.actualizar(sugerenciaAModificar);
		Sugerencia sugerenciaModificada = sugerenciaDAO.recuperar(sugerenciaAModificar.getId());
		assertNotNull(sugerenciaModificada);
		assertEquals(sugerenciaAModificar.getDescripcion(), sugerenciaModificada.getDescripcion());
	}

	@Test
	public void testEliminarSugerencia() {
		  sugerenciaDAO.borrar(sugerenciaABorrar);
		  // Verificar si la entidad existe después de eliminar  
		  Sugerencia sugerenciaBorrada = sugerenciaDAO.recuperar(sugerenciaABorrar.getId());
		  assertNull(sugerenciaBorrada);
		  }
		 
	

	public void testBuscarSugerencia() {
		Sugerencia sugerenciaBuscada = sugerenciaDAO.recuperar(sugerenciaABuscar.getId());
		assertNotNull(sugerenciaBuscada);
		assertEquals(sugerenciaABuscar.getDescripcion(), sugerenciaBuscada.getDescripcion());

	}

	@AfterAll
	static void tearDown() {
		usuarioDAO.borrar(usuarioNuevo);
		rolDAO.borrar(rolAsignado);
	}

}
