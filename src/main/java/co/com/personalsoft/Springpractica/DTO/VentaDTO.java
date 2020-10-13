package co.com.personalsoft.Springpractica.DTO;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.personalsoft.Springpractica.modelo.Venta;

public interface VentaDTO extends JpaRepository<Venta, Integer> {

}
