package co.com.personalsoft.Springpractica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.personalsoft.Springpractica.DTO.CategoriaDTO;
import co.com.personalsoft.Springpractica.DTO.ContactenosDTO;
import co.com.personalsoft.Springpractica.DTO.CuentaDTO;
import co.com.personalsoft.Springpractica.DTO.DetalleVentaDTO;
import co.com.personalsoft.Springpractica.DTO.ProductoDTO;
import co.com.personalsoft.Springpractica.DTO.RolDTO;
import co.com.personalsoft.Springpractica.DTO.UsuarioDTO;
import co.com.personalsoft.Springpractica.DTO.VentaDTO;
import co.com.personalsoft.Springpractica.modelo.Categoria;
import co.com.personalsoft.Springpractica.modelo.Contactenos;
import co.com.personalsoft.Springpractica.modelo.Cuenta;
import co.com.personalsoft.Springpractica.modelo.DetalleVenta;
import co.com.personalsoft.Springpractica.modelo.Producto;
import co.com.personalsoft.Springpractica.modelo.Rol;
import co.com.personalsoft.Springpractica.modelo.Usuario;
import co.com.personalsoft.Springpractica.modelo.Venta;

@RestController
public class control {

	@Autowired
	private RolDTO rolDTO;
	@Autowired
	private CategoriaDTO categoriaDTO;
	@Autowired
	private ContactenosDTO contactenosDTO;
	@Autowired
	private ProductoDTO productoDTO;
	@Autowired
	private UsuarioDTO usuarioDTO;
	@Autowired
	private CuentaDTO cuentaDTO;
	@Autowired
	private VentaDTO ventaDTO;
	@Autowired
	private DetalleVentaDTO detalleVentaDTO;
		
	@GetMapping("/roles")
	public List<Rol> listarRoles(){
		List<Rol> roles = rolDTO.findAll();
		return roles;
	}
	
	@GetMapping("/categorias")
	public List<Categoria> listarCategorias(){
		List<Categoria> categorias = categoriaDTO.findAll();
		return categorias;
	}	
	
	@GetMapping("/contactenos")
	public List<Contactenos> listarContactenos(){
		List<Contactenos> contactenos = contactenosDTO.findAll();
		return contactenos;
	}	
	
	@GetMapping("/productos")
	public List<Producto> listarProductos(){
		List<Producto> productos = productoDTO.findAll();
		return productos;
	}
	
	@GetMapping("/usuarios")
	public List<Usuario> listarUsuarios(){
		List<Usuario> usuarios = usuarioDTO.findAll();
		return usuarios;
	}
	
	@GetMapping("/cuentas")
	public List<Cuenta> listarCuentas(){
		List<Cuenta> cuentas = cuentaDTO.findAll();
		return cuentas;
	}
	
	@GetMapping("/ventas")
	public List<Venta> listarVentas(){
		List<Venta> ventas = ventaDTO.findAll();
		return ventas;
	}
	
	@GetMapping("/detalles")
	public List<DetalleVenta> listarDetalles(){
		List<DetalleVenta> detalleVentas = detalleVentaDTO.findAll();
		return detalleVentas;
	}
	
	
}
