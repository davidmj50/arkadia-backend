package co.com.personalsoft.Springpractica.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="tbl_ventas")

public class Venta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_Venta;
	@Column
	private String comprobante_Venta;
	@Column
	private Date fecha_Venta;
	@Column
	private int total_Venta;
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	public int getId_Venta() {
		return id_Venta;
	}
	public void setId_Venta(int id_Venta) {
		this.id_Venta = id_Venta;
	}
	public String getComprobante_Venta() {
		return comprobante_Venta;
	}
	public void setComprobante_Venta(String comprobante_Venta) {
		this.comprobante_Venta = comprobante_Venta;
	}
	public Date getFecha_Venta() {
		return fecha_Venta;
	}
	public void setFecha_Venta(Date fecha_Venta) {
		this.fecha_Venta = fecha_Venta;
	}
	public int getTotal_Venta() {
		return total_Venta;
	}
	public void setTotal_Venta(int total_Venta) {
		this.total_Venta = total_Venta;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
		
}
