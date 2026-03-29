package uis.edu.entorno.tienda.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import uis.edu.entorno.tienda.modelo.Producto;
import uis.edu.entorno.tienda.modelo.Proveedor;
import uis.edu.entorno.tienda.servicio.IproveedorService;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    @Autowired
    private IproveedorService proveedorService;

    @GetMapping("/list")
    public List<Proveedor> listar() {
        return proveedorService.getProveedores();
    }

    @GetMapping("/list/{id}")
    public Proveedor buscarPorId(@PathVariable Long id) {
        return proveedorService.buscarProveedor(id);
    }

    @PostMapping("/post")
    public ResponseEntity<Proveedor> agregar(@Valid @RequestBody Proveedor proveedor) {
        Proveedor obj = proveedorService.nuevoProveedor(proveedor);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping("/put")
    public ResponseEntity<Proveedor> editar(@Valid @RequestBody Proveedor proveedor) {
        Proveedor obj = proveedorService.buscarProveedor(proveedor.getId());
        if (obj != null) {
            obj.setNombre(proveedor.getNombre());
            obj.setCiudad(proveedor.getCiudad());
            obj.setDireccion(proveedor.getDireccion());
            obj.setTelefono(proveedor.getTelefono());
            obj.setNit(proveedor.getNit());

            proveedorService.nuevoProveedor(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
	public ResponseEntity<Proveedor> eliminar(@PathVariable Long id){
		Proveedor obj= proveedorService.buscarProveedor(id);
		if(obj != null) {
			
			proveedorService.borrarProveedor(id);
			
			
		}else {
			return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
			 
			
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
}