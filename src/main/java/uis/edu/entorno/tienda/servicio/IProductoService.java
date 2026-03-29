package uis.edu.entorno.tienda.servicio;

import java.util.List;

import uis.edu.entorno.tienda.modelo.Producto;

public interface IProductoService {

//	Se agregan las cabeceras de los métodos a program
	
	List<Producto> getProducto();
	
	Producto NuevoProducto(Producto usuario);
	
	Producto BuscarProducto(Long id);
	
	int BorrarProducto(Long id);
	
  
}
