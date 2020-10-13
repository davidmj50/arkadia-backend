package co.com.personalsoft.Springpractica.DTO;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.personalsoft.Springpractica.modelo.Usuario;

public interface UsuarioDTO extends JpaRepository<Usuario, Integer> {

}
