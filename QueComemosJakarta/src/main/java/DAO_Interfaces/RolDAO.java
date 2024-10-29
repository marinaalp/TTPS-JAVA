package DAO_Interfaces;

import model.Rol;

public interface RolDAO extends GenericDAO<Rol> {
	Rol obtenerPorNombre(String nombreRol);
}
