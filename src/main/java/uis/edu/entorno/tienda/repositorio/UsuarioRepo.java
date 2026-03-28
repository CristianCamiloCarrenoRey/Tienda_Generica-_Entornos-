package uis.edu.entorno.tienda.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import uis.edu.entorno.tienda.modelo.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Long> {

}
