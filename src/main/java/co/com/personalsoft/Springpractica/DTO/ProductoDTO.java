package co.com.personalsoft.Springpractica.DTO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.com.personalsoft.Springpractica.modelo.Producto;

public interface ProductoDTO extends JpaRepository<Producto, Integer> {
	
	@Query("select p from Producto p where p.categoria.id_Categoria = ?1")
	public List<Producto> getProductsByIdCategory(int idCategory);
	
	@Query("select p from Producto p where p.id_Producto = ?1")
	public List<Producto> getProductsByIdProduct(int idProduct);
	
	@Query("SELECT p FROM Producto p WHERE p.nombre_Producto LIKE %?1%")
	public List<Producto> getProductsByName(String nameProduct);

}
