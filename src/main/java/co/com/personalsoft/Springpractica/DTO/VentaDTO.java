package co.com.personalsoft.Springpractica.DTO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.com.personalsoft.Springpractica.modelo.Venta;

public interface VentaDTO extends JpaRepository<Venta, Integer> {

	@Query("SELECT v FROM Venta v WHERE v.id_Venta = ?1")
	public List<Venta> getIdUser(int idVenta);
	
}
