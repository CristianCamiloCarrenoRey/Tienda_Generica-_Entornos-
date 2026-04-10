package uis.edu.entorno.tienda.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uis.edu.entorno.tienda.modelo.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
	
	//JPL se hace la consulta sobre la clase
	
	@Query("select count(*) from Usuario as p where p.nombreUsuario= :nombreUsuario and p.password= :password ")// la coonsulta devuelve el numero de usuarios y el password
	Integer findByNombreUsuarioAndPassword(@Param("nombreUsuario") String  nombreUsuario, @Param("password") String password);
	
	@Query("select p from Usuario as p where p.nombreUsuario= :nombreUsuario and p.password= :password ")// devolver el objeto tipo usuario 
	Usuario findByNameAndPassword(@Param("nombreUsuario") String  nombreUsuario, @Param("password") String password);


}
