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

import co.com.personalsoft.Springpractica.DTO.CategoriaDTO;
import co.com.personalsoft.Springpractica.modelo.Categoria;

@CrossOrigin(origins= "http://localhost:4200", maxAge=3600)
@RestController
public class ControlCategoria {

	@Autowired
	private CategoriaDTO categoriaDTO;
	
	@GetMapping("/categorias")
    public List<Categoria> listarCategorias(){
        List<Categoria> categorias = categoriaDTO.findAll();
        return categorias;
    }
    
    @PostMapping("/categorias")
    public  void newCategoria(@RequestBody Categoria categoria) {
      categoriaDTO.save(categoria);
    }
    
    @GetMapping("/categorias/{id_categoria}")
    public Optional<Categoria> categoriaId(@PathVariable("id_categoria") int idCategoria){
        Optional<Categoria> categorias = categoriaDTO.findById(idCategoria);
        return categorias;
    }
    
    @PutMapping("/categorias/{id_categoria}")
    public Categoria editCategoria(@RequestBody Categoria c, @PathVariable("id_categoria") int idCategoria ) {
    	Optional<Categoria> o = categoriaDTO.findById(idCategoria);
    	Categoria categoria = o.get();
    	c.setId_Categoria(categoria.getId_Categoria());
    	categoriaDTO.save(c);
    	return categoria;
    }
    
    @DeleteMapping("/categorias/{id_categoria}")
	public void deleteCategoria(@PathVariable("id_categoria") int idCategoria) {
		categoriaDTO.deleteById(idCategoria);
		
	}
	
}
