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
import co.com.personalsoft.Springpractica.DTO.DetalleVentaDTO;
import co.com.personalsoft.Springpractica.DTO.ProductoDTO;
import co.com.personalsoft.Springpractica.DTO.VentaDTO;
import co.com.personalsoft.Springpractica.modelo.Cuenta;
import co.com.personalsoft.Springpractica.modelo.DetalleVenta;
import co.com.personalsoft.Springpractica.modelo.Producto;
import co.com.personalsoft.Springpractica.modelo.Usuario;
import co.com.personalsoft.Springpractica.modelo.Venta;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController

public class ControlDetalleVenta {

	@Autowired
    private DetalleVentaDTO detalleventaDTO;
	@Autowired
	private CuentaDTO cuentaDTO;	
	@Autowired
	private VentaDTO ventaDTO;
	@Autowired
	private ProductoDTO productoDTO;
	@Autowired
	private ControlCuenta controlCuenta;
	@Autowired
	private ControlProducto controlProducto;
	
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
    	Optional<DetalleVenta> o = detalleventaDTO.findById(iddetalle);
    	DetalleVenta detalleventa = o.get();
    	d.setId_Detalle(detalleventa.getId_Detalle());
    	detalleventaDTO.save(d);
    	return detalleventa;
    }

    @DeleteMapping("/detalleventa/{id_detalle}")
    public void deleteDetalleVenta(@PathVariable("id_detalle") int iddetalle) {
        detalleventaDTO.deleteById(iddetalle);
    }
    
    @PostMapping("/detalleventasaveall")
    public String listDetalleVentas(@RequestBody List<DetalleVenta> detalleVentas) {
    	detalleventaDTO.saveAll(detalleVentas);
    	Venta venta = detalleVentas.get(0).getVenta();
    	List<Venta> ventas = (List<Venta>) ventaDTO.getIdUser(venta.getId_Venta());
    	Usuario usuario = ventas.get(0).getUsuario();
    	double totalMonto = 0;
    	for(DetalleVenta detalle: detalleVentas) {
    		totalMonto += detalle.getMonto();
    		Producto producto = detalle.getProducto();
    		List<Producto> productos = productoDTO.getProductsByIdProduct(producto.getId_Producto());
    		producto = productos.get(0);
    		int stock = producto.getStock() - detalle.getCantidad();
    		producto.setStock(stock);
    		controlProducto.editProducto(producto, producto.getId_Producto());    		
    	}
    	List<Cuenta> cuentas = cuentaDTO.getPointsByIdUser(usuario.getId_Usuario());
    	int nuevoSaldo = (int) (cuentas.get(0).getCantidad_Puntos() - totalMonto);
    	Cuenta cuenta = new Cuenta();
    	cuenta = cuentas.get(0);
    	cuenta.setCantidad_Puntos(nuevoSaldo);
    	controlCuenta.editCuenta(cuenta, cuenta.getId_Cuenta());
    	
    	return "Detalles almacenados ";
    }
    
	
}
