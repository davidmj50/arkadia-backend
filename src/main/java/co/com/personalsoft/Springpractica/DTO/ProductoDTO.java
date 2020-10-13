package co.com.personalsoft.Springpractica.DTO;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.personalsoft.Springpractica.modelo.Producto;

public interface ProductoDTO extends JpaRepository<Producto, Integer> {

}
