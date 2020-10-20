package co.com.personalsoft.Springpractica.DTO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.com.personalsoft.Springpractica.modelo.Contactenos;

public interface ContactenosDTO extends JpaRepository<Contactenos, Integer> {
	
	@Query("select c from Contactenos c where c.atendido = false")
	public List<Contactenos> getListContacts();

}
