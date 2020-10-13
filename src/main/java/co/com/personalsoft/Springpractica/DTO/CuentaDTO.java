package co.com.personalsoft.Springpractica.DTO;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.personalsoft.Springpractica.modelo.Cuenta;

public interface CuentaDTO extends JpaRepository<Cuenta, Integer> {

}
