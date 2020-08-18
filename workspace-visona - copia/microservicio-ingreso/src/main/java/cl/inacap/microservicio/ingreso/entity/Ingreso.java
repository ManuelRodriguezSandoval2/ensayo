package cl.inacap.microservicio.ingreso.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="INGRESO")
public class Ingreso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="ID_INGRESO")	
	private Long id;
	
	@Column(name="NUMERO_GUIA")	
	private int numero_guia;
	
	@Column(name="USUARIO")	
	private String usuario;
	
	@Column(name="CANTIDAD")	
	private int cantidad;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_INGRESO")		
	private Date fecha_ingreso;
	
	@PrePersist
	public void prePersist() {
		this.fecha_ingreso=new Date();
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumero_guia() {
		return numero_guia;
	}
	public void setNumero_guia(int numero_guia) {
		this.numero_guia = numero_guia;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}
	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	
}
