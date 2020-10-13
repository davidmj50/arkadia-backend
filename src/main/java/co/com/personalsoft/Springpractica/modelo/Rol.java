package co.com.personalsoft.Springpractica.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tbl_rol")

public class Rol {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_rol;
	@Column
	private String nombre_Rol;
	public int getId_rol() {
		return id_rol;
	}
	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}
	public String getNombre_Rol() {
		return nombre_Rol;
	}
	public void setNombre_Rol(String nombre_Rol) {
		this.nombre_Rol = nombre_Rol;
	}		
}
