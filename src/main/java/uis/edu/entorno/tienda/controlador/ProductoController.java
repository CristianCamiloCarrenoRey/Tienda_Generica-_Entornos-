package uis.edu.entorno.tienda.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import uis.edu.entorno.tienda.modelo.Producto;
import uis.edu.entorno.tienda.servicio.ProdictoService;


@RestController
@RequestMapping("/api/productos")
public class ProductoController {

	@Autowired
	ProdictoService productoService;
	
	// listar los Usuario
	
	@GetMapping("list")
	public ResponseEntity<List<Producto>> findAll(){
		return ResponseEntity.ok(productoService.getProducto());
		
	}
	@GetMapping("/list/{id}")
	public Producto buscarPorId(@PathVariable Long id) {
		return productoService.BuscarProducto(id);
	}
	
	//Agregar Usuario
	@PostMapping("/post")
	public ResponseEntity<Producto> agregar(@Valid @RequestBody Producto producto){
		Producto obj= productoService.NuevoProducto(producto);
		return new ResponseEntity<>(obj, HttpStatus.OK);
		
	}
	
	//Actualizar Usuario
	
	@PutMapping("/put")
	public ResponseEntity<Producto> editar(@ Valid @RequestBody Producto producto){
		Producto obj= productoService.BuscarProducto(producto.getId());
		if(obj != null) {
			obj.setIdProveedor(producto.getIdProveedor());
			obj.setIvaCompra(producto.getIvaCompra());
			obj.setNombre(producto.getNombre());
			obj.setPrecioCompra(producto.getPrecioCompra());
			obj.setPrecioVenta(producto.getPrecioVenta());
			
			productoService.NuevoProducto(obj);
			
			
		}else {
			return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
			 
			
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
		 
	}
	
	//Borra Usuario 
	@DeleteMapping("/{id}")
	public ResponseEntity<Producto> eliminar(@PathVariable Long id){
		Producto obj= productoService.BuscarProducto(id);
		if(obj != null) {
			
			productoService.BorrarProducto(id);
			
			
		}else {
			return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
			 
			
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	

}
