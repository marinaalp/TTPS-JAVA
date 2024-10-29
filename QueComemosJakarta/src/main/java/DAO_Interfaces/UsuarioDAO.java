package DAO_Interfaces;

import model.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario> {
	Usuario obtenerPorEmail(String email);
}