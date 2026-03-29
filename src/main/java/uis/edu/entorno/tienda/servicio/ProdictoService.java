package uis.edu.entorno.tienda.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uis.edu.entorno.tienda.modelo.Producto;
import uis.edu.entorno.tienda.repositorio.PorductoRepo;

@Service 
@Transactional
public class ProdictoService implements IProductoService {
	@Autowired
	PorductoRepo productoRepo;

	@Override
	public List<Producto> getProducto() {
		// Mostrar usuarios  
		return productoRepo.findAll();
	}

	@Override
	public Producto NuevoProducto(Producto producto) {
		// Nuevo producto 
		return productoRepo.save(producto);
	}

	@Override
	public Producto BuscarProducto(Long id) {
		// buscar por  id 
		Producto producto= null;
		producto = productoRepo.findById(id).orElse(null);
		
		if(producto == null) {
			return null;
		}
		
		return producto;
	}

	@Override
	public int BorrarProducto(Long id) {
		// Borrar producto
		productoRepo.deleteById(id);
		return 1;
	}
	



}
