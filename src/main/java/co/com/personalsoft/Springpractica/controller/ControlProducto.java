package co.com.personalsoft.Springpractica.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.personalsoft.Springpractica.DTO.ProductoDTO;
import co.com.personalsoft.Springpractica.modelo.Producto;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController

public class ControlProducto {

	 @Autowired
	 private ProductoDTO productoDTO;
	 @PersistenceContext
	 private EntityManager em;
	 	
	@GetMapping("/producto")
    public List<Producto> buscarProducto() {
        List<Producto> producto = productoDTO.findAll();
        return producto;
    }

    @PostMapping("/producto")
    public void newProducto(@RequestBody Producto p) {
        productoDTO.save(p);
    }

    @GetMapping("/producto/{id_producto}")
    public Optional<Producto> Productoid(@PathVariable("id_producto") int idproducto) {
        Optional<Producto> producto = productoDTO.findById(idproducto);
        return producto;
    }

    @PutMapping("/producto/{id_producto}")
    public Producto editProducto(@RequestBody Producto p, @PathVariable("id_producto") int idproducto) {
        Optional<Producto> o = productoDTO.findById(idproducto);
        Producto producto = o.get();
        p.setId_Producto(producto.getId_Producto());
        productoDTO.save(p);
    	return producto;
    }

    @DeleteMapping("/producto/{id_producto}")
    public void deleteProducto(@PathVariable("id_producto") int idproducto) {
        productoDTO.deleteById(idproducto);
    }
    
    @GetMapping("/producto/prodcategoria/{id_categoria}")
    public List<Producto> ProductoCatg(@PathVariable("id_categoria") int idcategoria) {
    	List<Producto> productos = this.productoDTO.getProductsByIdCategory(idcategoria);
        return productos;
    }
	
}
