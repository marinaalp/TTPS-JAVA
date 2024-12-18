package DAO_Interfaces;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T> {

	public T actualizar(T entity);

	public void borrar(T entity);

	public T borrar(Long id);

	public boolean existe(Long id);

	public T persistir(T entity);

	public T recuperar(Serializable id);

	public List<T> recuperarTodos(String column);

}