package co.com.personalsoft.Springpractica.DTO;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.personalsoft.Springpractica.modelo.Contactenos;

public interface ContactenosDTO extends JpaRepository<Contactenos, Integer> {

}
