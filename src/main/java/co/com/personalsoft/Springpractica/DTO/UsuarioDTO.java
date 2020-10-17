package co.com.personalsoft.Springpractica.DTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.com.personalsoft.Springpractica.modelo.Usuario;

public interface UsuarioDTO extends JpaRepository<Usuario, Integer> {

	@Query("SELECT u FROM Usuario u WHERE u.userName = ?1 AND u.password =?2")
	Iterable<Usuario> validateUsername(String userName, String password);	
}
