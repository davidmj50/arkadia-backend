package co.com.personalsoft.Springpractica.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="tbl_cuenta")

public class Cuenta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_Cuenta;
	@Column
	private int cantidad_Puntos;
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	public int getId_Cuenta() {
		return id_Cuenta;
	}
	public void setId_Cuenta(int id_Cuenta) {
		this.id_Cuenta = id_Cuenta;
	}
	public int getCantidad_Puntos() {
		return cantidad_Puntos;
	}
	public void setCantidad_Puntos(int cantidad_Puntos) {
		this.cantidad_Puntos = cantidad_Puntos;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
