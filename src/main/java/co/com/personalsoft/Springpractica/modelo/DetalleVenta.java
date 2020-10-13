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
@Table (name="tbl_detalle_venta")

public class DetalleVenta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_Detalle;
	@Column
	private int cantidad;
	@Column
	private float descuento;
	@Column
	private float valor_Descuento;
	@Column
	private float monto;
	@ManyToOne
	@JoinColumn(name = "id_venta")
	private Venta venta;
	@ManyToOne
	@JoinColumn(name = "id_producto")
	private Producto producto;
	
	public int getId_Detalle() {
		return id_Detalle;
	}
	public void setId_Detalle(int id_Detalle) {
		this.id_Detalle = id_Detalle;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float getDescuento() {
		return descuento;
	}
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
	public float getValor_Descuento() {
		return valor_Descuento;
	}
	public void setValor_Descuento(float valor_Descuento) {
		this.valor_Descuento = valor_Descuento;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public Venta getVenta() {
		return venta;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
		
	
}
