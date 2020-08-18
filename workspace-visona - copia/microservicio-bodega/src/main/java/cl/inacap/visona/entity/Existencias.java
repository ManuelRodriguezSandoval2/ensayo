package cl.inacap.visona.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name="EXISTENCIA")
public class Existencias {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
	@Column(name="ID_EXISTENCIA")	
	private Long id;
	
	@Column(name="NUMERO_GUIA")
	private int numeroGuia;
	
	@Column(name="USUARIO")
	private String usuario;	
	
	@Column(name = "VALOR_UNITARIO")
	private int valorUnitario;
	
	@Column(name="STOCK")	
	private int stock;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_INGRESO")	
	private Date fechaIngreso;
	
	//foraneas
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne
	@JoinColumn(name="ID_PRODUCTO", nullable = false)
	private Producto producto;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne
	@JoinColumn(name="ID_BODEGA", nullable = false )	
	private Bodega bodega;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne
	@JoinColumn(name="ID_PROVEEDOR", nullable = false)
	private Proveedor proveedor;
	
	@PrePersist
	public void prePersist() {
		this.fechaIngreso=new Date();
	}
	





	public Existencias(Long id, int numeroGuia, String usuario, int stock, Date fechaIngreso, Producto producto,
			Bodega bodega, Proveedor proveedor) {
		super();
		this.id = id;
		this.numeroGuia = numeroGuia;
		this.usuario = usuario;
		this.stock = stock;
		this.fechaIngreso = fechaIngreso;
		this.producto = producto;
		this.bodega = bodega;
		this.proveedor = proveedor;
	}



	public Existencias() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(int valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public int getNumeroGuia() {
		return numeroGuia;
	}


	public void setNumeroGuia(int numeroGuia) {
		this.numeroGuia = numeroGuia;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}




	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public Date getFechaIngreso() {
		return fechaIngreso;
	}


	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	
	public Producto getProducto() {
		return producto;
	}

	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	
	public Bodega getBodega() {
		return bodega;
	}

	
	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

	
	public Proveedor getProveedor() {
		return proveedor;
	}


	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}


	@Override
	public boolean equals(Object obj) {

		if(!(obj instanceof Existencias)) {
			return false;
		}
		Existencias cp =(Existencias) obj;
		
		return this.id!=null&&this.id.equals((cp.getId()));
	
	}
	

	

}
