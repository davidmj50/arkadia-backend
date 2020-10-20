package co.com.personalsoft.Springpractica.DTO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.com.personalsoft.Springpractica.modelo.Cuenta;

public interface CuentaDTO extends JpaRepository<Cuenta, Integer> {
	
	@Query("SELECT c FROM Cuenta c WHERE c.usuario.id_Usuario = ?1")
	public List<Cuenta> getPointsByIdUser(int idUser);
		
}
