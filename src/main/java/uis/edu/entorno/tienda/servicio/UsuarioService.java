package uis.edu.entorno.tienda.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
