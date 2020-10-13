package co.com.personalsoft.Springpractica.DTO;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.personalsoft.Springpractica.modelo.DetalleVenta;

public interface DetalleVentaDTO extends JpaRepository<DetalleVenta, Integer> {

}
