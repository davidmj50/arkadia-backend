package co.com.personalsoft.Springpractica.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="tbl_categorias")

public class Categoria {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_Categoria;
	@Column
	private String nombre_Categoria;
	@Column
	private String descripcion;
	public int getId_Categoria() {
		return id_Categoria;
	}
	public void setId_Categoria(int id_Categoria) {
		this.id_Categoria = id_Categoria;
	}
	public String getNombre_Categoria() {
		return nombre_Categoria;
	}
	public void setNombre_Categoria(String nombre_Categoria) {
		this.nombre_Categoria = nombre_Categoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
