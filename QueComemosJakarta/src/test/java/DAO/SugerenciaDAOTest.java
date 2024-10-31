package DAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
	private static Sugerencia sugerenciaAModifcar;
	private static Sugerencia sugerenciaABorrar;
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

	}

	public void testModificarSugerencia() {

	}

	public void testEliminarSugerencia() {

	}

	public void testBuscarSugerencia() {

	}
	
	@AfterAll
	static void tearDown() {
		sugerenciaDAO.borrar(sugerenciaNueva);
		// Introduce a short delay (adjust as needed)
		/*
		 * try { Thread.sleep(3000); // Sleep for 1 second } catch (InterruptedException
		 * e) { e.printStackTrace(); }
		 * 
		 * usuarioDAO.borrar(usuarioNuevo); try { Thread.sleep(3000); // Sleep for 1
		 * second } catch (InterruptedException e) { e.printStackTrace(); }
		 * 
		 * rolDAO.borrar(rolAsignado);
		 */

	}

}
