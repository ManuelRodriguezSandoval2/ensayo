package cl.inacap.visona.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "PRODUCTO")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "ID_PRODUCTO")
	private Long id;

	@Column(name = "NOMBRE_PRODUCTO")
	private String nombreProducto;

	@Column(name = "MARCA_PRODUCTO")
	private String marcaProducto;

	

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_PRODUCTO", nullable = false)
	private TipoProducto tipoProducto;

	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TRASPASO")
	@JsonIgnore
	private Traspasos traspasos;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PROVEEDOR")
	@JsonIgnore
	private Proveedor proveedor;*/
	
	@JsonIgnore
	@OneToMany(mappedBy = "producto")
	private List<Existencias> existencia;

	public Producto() {

		this.existencia = new ArrayList<>();
	}
	
	
	
	public Producto(Long id, String nombreProducto) {
		super();
		this.id = id;
		this.nombreProducto = nombreProducto;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getMarcaProducto() {
		return marcaProducto;
	}

	public void setMarcaProducto(String marcaProducto) {
		this.marcaProducto = marcaProducto;
	}

	

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public List<Existencias> getExistencias() {
		return existencia;
	}

	public void setExistencias(List<Existencias> existencias) {
		this.existencia = existencias;
	}

	/*	public Traspasos getTraspasos() {
		return traspasos;
	}

	public void setTraspasos(Traspasos traspasos) {
		this.traspasos = traspasos;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}*/

	public List<Existencias> getExistencia() {
		return existencia;
	}

	public void setExistencia(List<Existencias> existencia) {
		this.existencia = existencia;
	}
	public void addExistencia(Existencias existencia) {
		this.existencia.add(existencia);
	}
	public void removeExistencia(Existencias existencia) {
		this.existencia.remove(existencia);
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Producto)) {
			return false;
		}
		Producto cp = (Producto) obj;

		return this.id != null && this.id.equals((cp.getId()));

	}

}
