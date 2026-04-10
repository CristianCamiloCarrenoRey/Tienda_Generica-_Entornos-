package uis.edu.entorno.tienda.servicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uis.edu.entorno.tienda.modelo.LoginDto;
import uis.edu.entorno.tienda.modelo.Usuario;
import uis.edu.entorno.tienda.repositorio.UsuarioRepo;

@Service
@Transactional 
public class UsuarioService  implements IUsuarioService{
	
	@Autowired
	UsuarioRepo usuarioRepositorio;
	@Override
	public List<Usuario> getUsuarios() {
		// mostrar los usuarios que hay 
		return usuarioRepositorio.findAll();
	}

	@Override
	public Usuario NuevoUsuario(Usuario usuario) {
		// nuevo usauario
		return usuarioRepositorio.save(usuario);
	}

	@Override
	public Usuario BuscarUsuario(Long id) {
		// Buscar  usuario en especifico 
		
		Usuario usuario = null;
		
		usuario= usuarioRepositorio.findById(id).orElse(null);
		
		if(usuario == null) {
		
		return null;
		}
		return usuario;
	}

	@Override
	public int BorrarUsuario(Long id) {
		// Borrar 
		usuarioRepositorio.deleteById(id);
		return 1;
	}

	@Override
	public int login(LoginDto UsuarioDto) {
		int u = usuarioRepositorio.findByNombreUsuarioAndPassword(UsuarioDto.getNombreUsuario(), UsuarioDto.getPassword());
		return u;
	}

	@Override
	public ResponseEntity<?> ingresar(LoginDto UsuarioDto) {
		// TODO Auto-generated method stub
		Map<String, Object > response = new HashMap<>();
		Usuario usuario = null;
		try{
			usuario = usuarioRepositorio.findByNameAndPassword(UsuarioDto.getNombreUsuario(), UsuarioDto.getPassword());
			if(usuario== null) {
				response.put("Usuario",null);
				response.put("Mensaje", "Alerta: Usuario  o Password incorrectos ");
				response.put("statusCode", HttpStatus.NOT_FOUND.value());
				return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
				
			}else {
				response.put("Usuario",usuario );
				response.put("Mensaje", "Dtos Correctos ");
				response.put("statusCode", HttpStatus.OK.value());
				return new ResponseEntity<>(response,HttpStatus.OK);
				
			}
			
		}catch(Exception e) {
			response.put("Usuario",null);
			response.put("Mensaje", "Ha ocurrido un error  ");
			response.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	
	}

}
