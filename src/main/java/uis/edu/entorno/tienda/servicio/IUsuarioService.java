package uis.edu.entorno.tienda.servicio;

import java.util.List;

import org.springframework.http.ResponseEntity;

import uis.edu.entorno.tienda.modelo.LoginDto;
import uis.edu.entorno.tienda.modelo.Usuario;

public interface IUsuarioService {
//	Se agregan las cabeceras de los métodos a program
	
	List<Usuario> getUsuarios();
	
	Usuario NuevoUsuario(Usuario usuario);
	
	Usuario BuscarUsuario(Long id);
	
	int BorrarUsuario(Long id);
	
	//metedodo de login 
	int login(LoginDto UsuarioDto);
	
	// objeto 
	ResponseEntity<?> ingresar(LoginDto UsuarioDto);
	
	
}
