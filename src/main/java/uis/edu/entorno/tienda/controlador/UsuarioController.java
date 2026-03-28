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
import org.springframework.web.bind.annotation.RestController;

import uis.edu.entorno.tienda.modelo.Usuario;
import uis.edu.entorno.tienda.servicio.UsuarioService;


@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	// listar los Usuario
	
	@GetMapping("/lis")
	public ResponseEntity<List<Usuario>> findAll(){
		return ResponseEntity.ok(usuarioService.getUsuarios());
		
	}
	@GetMapping("/lis/{id}")
	public Usuario buscarPorId(@PathVariable Long id) {
		return usuarioService.BuscarUsuario(id);
	}
	
	//Agregar Usuario
	@PostMapping("/post")
	public ResponseEntity<Usuario> agregar(@RequestBody Usuario usuario){
		Usuario obj= usuarioService.NuevoUsuario(usuario);
		return new ResponseEntity<>(obj, HttpStatus.OK);
		
	}
	
	//Actualizar Usuario
	
	@PutMapping("/put")
	public ResponseEntity<Usuario> editar(@RequestBody Usuario usuario){
		Usuario obj= usuarioService.BuscarUsuario(usuario.getId());
		if(obj != null) {
			obj.setEmail(usuario.getEmail());
			obj.setIdTipoDocumento(usuario.getIdTipoDocumento());
			obj.setNombre(usuario.getNombre());
			obj.setNombreUsuario(usuario.getNombreUsuario());
			obj.setPassword(usuario.getPassword());
			usuarioService.NuevoUsuario(obj);
			
			
		}else {
			return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
			 
			
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
		 
	}
	
	//Borra Usuario 
	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> eliminar(@PathVariable Long id){
		Usuario obj= usuarioService.BuscarUsuario(id);
		if(obj != null) {
			
			usuarioService.BorrarUsuario(id);
			
			
		}else {
			return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
			 
			
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	

}
