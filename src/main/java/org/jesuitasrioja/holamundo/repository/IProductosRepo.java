package org.jesuitasrioja.holamundo.repository;

import java.util.List;

import org.jesuitasrioja.holamundo.modelo.Producto;

public interface IProductosRepo {

	Producto getById(String id);

	List<Producto> getAll();

	boolean addProducto(Producto p);

	boolean rmProducto(String id);

}