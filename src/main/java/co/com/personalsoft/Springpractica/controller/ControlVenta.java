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

import co.com.personalsoft.Springpractica.DTO.VentaDTO;
import co.com.personalsoft.Springpractica.modelo.Venta;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController

public class ControlVenta {

	@Autowired
    private VentaDTO ventaDTO;

    @GetMapping("/venta")
    public List<Venta> buscarVenta() {
        List<Venta> venta = ventaDTO.findAll();
        return venta;
    }

    @PostMapping("/venta")
    public void newVenta(@RequestBody Venta v) {
        ventaDTO.save(v);
    }

    @GetMapping("/venta/{id_venta}")
    public Optional<Venta> Ventaid(@PathVariable("id_venta") int idventa) {
        Optional<Venta> venta = ventaDTO.findById(idventa);
        return venta;
    }

    @PutMapping("/venta/{id_venta}")
    public Venta editVenta(@RequestBody Venta v, @PathVariable("id_venta") int idventa) {
        Optional<Venta> o = ventaDTO.findById(idventa);
        Venta venta = o.get();
        v.setId_Venta(venta.getId_Venta());
        ventaDTO.save(v);
    	return venta;
    }

    @DeleteMapping("/venta/{id_venta}")
    public void deleteVenta(@PathVariable("id_venta") int idventa) {
        ventaDTO.deleteById(idventa);
    }
	
}
