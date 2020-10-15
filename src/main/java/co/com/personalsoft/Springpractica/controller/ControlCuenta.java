package co.com.personalsoft.Springpractica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.personalsoft.Springpractica.DTO.CuentaDTO;
import co.com.personalsoft.Springpractica.modelo.Cuenta;

@CrossOrigin(origins= "http://localhost:4200", maxAge=3600)
@RestController
public class ControlCuenta {

	@Autowired
	private CuentaDTO cuentaDTO;
	
	@GetMapping("/cuentas")
	public List<Cuenta> listarCuentas(){
		List<Cuenta> cuentas = cuentaDTO.findAll();
		return cuentas;
	}
	
	@PostMapping("/cuentas")
	public void newCuenta(@RequestBody Cuenta cuenta) {
		cuentaDTO.save(cuenta);
	}
	
	@GetMapping("/cuentas/{id_cuenta}")
	public Optional<Cuenta> cuentaId(@PathVariable("id_cuenta") int idCuenta){
		Optional<Cuenta> cuentas = cuentaDTO.findById(idCuenta);
		return cuentas;
	}
	
	@PutMapping("/cuentas/{id_cuenta}")
	public Cuenta editCuenta(@RequestBody Cuenta c, @PathVariable("id_cuenta") int idCuenta ) {
		Cuenta cuenta = cuentaDTO.save(c);
		return cuenta;
	}
	
	@DeleteMapping("/cuentas/{id_cuenta}")
	public void deleteCuenta(@PathVariable("id_cuenta") int idCuenta) {
		cuentaDTO.deleteById(idCuenta);
	}
	
}
