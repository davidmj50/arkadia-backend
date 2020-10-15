package co.com.personalsoft.Springpractica.controller;

import co.com.personalsoft.Springpractica.DTO.DetalleVentaDTO;
import co.com.personalsoft.Springpractica.modelo.DetalleVenta;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController

public class controlDetalleVenta {

    @Autowired
    private DetalleVentaDTO detalleventaDTO;

    @GetMapping("/detalleventa")
    public List<DetalleVenta> buscarDetalleventa() {
        List<DetalleVenta> detalleventa = detalleventaDTO.findAll();
        return detalleventa;
    }

    @PostMapping("/detalleventa")
    public void newDetalleVenta(@RequestBody DetalleVenta d) {
        detalleventaDTO.save(d);
    }

    @GetMapping("/detalleventa/{id_detalle}")
    public Optional<DetalleVenta> DetalleVentaid(@PathVariable("id_detalle") int iddetalle) {
        Optional<DetalleVenta> detalleventa = detalleventaDTO.findById(iddetalle);
        return detalleventa;
    }

    @PutMapping("/detalleventa/{id_detalle}")
    public DetalleVenta editDetalleVenta(@RequestBody DetalleVenta d, @PathVariable("id_detalle") int iddetalle) {
        DetalleVenta detalleventa = detalleventaDTO.save(d);
        return detalleventa;
    }

    @DeleteMapping("/detalleventa/{id_detalle}")
    public void deleteDetalleVenta(@PathVariable("id_detalle") int iddetalle) {
        detalleventaDTO.deleteById(iddetalle);
    }

}
