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
import uis.edu.entorno.tienda.modelo.LoginDto;
import uis.edu.entorno.tienda.modelo.Usuario;
import uis.edu.entorno.tienda.servicio.UsuarioService;


@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	// listar los Usuario
	
	@GetMapping("/list")
	public ResponseEntity<List<Usuario>> findAll(){
		return ResponseEntity.ok(usuarioService.getUsuarios());
		
	}
	@GetMapping("/list/{id}")
	public Usuario buscarPorId(@PathVariable Long id) {
		return usuarioService.BuscarUsuario(id);
	}
	
	//Agregar Usuario
	@PostMapping("/post")
	public ResponseEntity<Usuario> agregar(@Valid @RequestBody Usuario usuario){
		Usuario obj= usuarioService.NuevoUsuario(usuario);
		return new ResponseEntity<>(obj, HttpStatus.OK);
		
	}
	
	//Actualizar Usuario
	
	@PutMapping("/put")
	public ResponseEntity<Usuario> editar(@Valid @RequestBody Usuario usuario){
		Usuario obj= usuarioService.BuscarUsuario(usuario.getId());
		if(obj != null) {
			obj.setEmail(usuario.getEmail());
			obj.setIdTipoDocumento(usuario.getIdTipoDocumento());
			obj.setNombre(usuario.getNombre());
			obj.setNombreUsuario(usuario.getNombreUsuario());
			obj.setNumeroDocumento(usuario.getNumeroDocumento());
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
	
	@PostMapping("/loginclient")// ruta del servicio desde el front deden direccionar a esta ruta 
	public int login(@RequestBody  LoginDto usuario ) {
		int responseLogin = usuarioService.login(usuario);
		return responseLogin;
	}
	
	
	@PostMapping("/login")//ruta del servicio desde el front deben direccionar etsa ruta 
	public ResponseEntity<?> loginCliente(@RequestBody LoginDto usuario){
		return usuarioService.ingresar(usuario);
	}
}
