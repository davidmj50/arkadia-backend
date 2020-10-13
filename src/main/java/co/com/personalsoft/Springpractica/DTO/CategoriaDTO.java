package co.com.personalsoft.Springpractica.DTO;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.personalsoft.Springpractica.modelo.Categoria;

public interface CategoriaDTO extends JpaRepository<Categoria, Integer> {

}
