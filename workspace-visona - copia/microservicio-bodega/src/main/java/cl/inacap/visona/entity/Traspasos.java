package cl.inacap.visona.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="TRASPASO")
public class Traspasos {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
	@Column(name="ID_TRASPASO")
	private Long id;
	
	@Column(name="CANTIDAD")	
	private int cantidad;
	
	@Column(name="BODEGA_ENTRANTE")
	private String bodegaEntrante;
	
	@Column(name="BODEGA_SALIENTE")
	private String bodegaSaliente;
	
	@Column(name="MEDIDA_ESTANDAR")
	private String medidaEstandar;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_TRASPASO")	
	
	private Date fechaTraspaso;
	
	@PrePersist
	public void prePersist() {
		this.fechaTraspaso=new Date();
	}
	
	/*@OneToMany(cascade= CascadeType.ALL, fetch =FetchType.LAZY, mappedBy = "traspasos")
	private List<Producto>producto;*/
	
	public Traspasos() {
		
		//this.producto=new ArrayList<>();
		
	}
	
	

	public Traspasos(Long id, int cantidad, String bodegaEntrante, String bodegaSaliente, String medidaEstandar,
			Date fechaTraspaso) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.bodegaEntrante = bodegaEntrante;
		this.bodegaSaliente = bodegaSaliente;
		this.medidaEstandar = medidaEstandar;
		this.fechaTraspaso = fechaTraspaso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getBodegaEntrante() {
		return bodegaEntrante;
	}

	public void setBodegaEntrante(String bodegaEntrante) {
		this.bodegaEntrante = bodegaEntrante;
	}

	public String getBodegaSaliente() {
		return bodegaSaliente;
	}

	public void setBodegaSaliente(String bodegaSaliente) {
		this.bodegaSaliente = bodegaSaliente;
	}

	public Date getFechaTraspaso() {
		return fechaTraspaso;
	}

	public void setFechaTraspaso(Date fechaTraspaso) {
		this.fechaTraspaso = fechaTraspaso;
	}
	
	public String getMedidaEstandar() {
		return medidaEstandar;
	}

	public void setMedidaEstandar(String medidaEstandar) {
		this.medidaEstandar = medidaEstandar;
	}

/*	public List<Producto> getProducto() {
		return producto;
	}

	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}
	public void addProducto(Producto producto) {
		this.producto.add(producto);
	}
	public void removeProducto(Producto producto) {
		this.producto.remove(producto);
	}*/
	
	
	
	
	@Override
	public boolean equals(Object obj) {

		if(!(obj instanceof Traspasos)) {
			return false;
		}
		Traspasos cp =(Traspasos) obj;
		
		return this.id!=null&&this.id.equals((cp.getId()));
	
	}

	
	
	

	
	
	
	
}

