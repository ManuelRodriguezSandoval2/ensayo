package cl.inacap.visona.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;



@Entity
@Table(name="TIPO_PRODUCTO")
public class TipoProducto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="ID_TIPO_PRODUCTO")	
	private Long id;
	
	@Column(name="NOMBRE_TIPO_PRODUCTO")	
	private String nombreTipoProducto;
	
	@Column(name="MEDIDA_ESTANDAR")	
	private String medidaEstandar;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tipoProducto")
	private List<Producto>producto;
	
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne
	@JoinColumn(name="ID_CATEGORIA", nullable = false)
	private CategoriaProducto categoriaProducto;
	
	
	public TipoProducto(){
		
		this.producto=new ArrayList<>();
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreTipoProducto() {
		return nombreTipoProducto;
	}

	public void setNombreTipoProducto(String nombreTipoProducto) {
		this.nombreTipoProducto = nombreTipoProducto;
	}

	public String getMedidaEstandar() {
		return medidaEstandar;
	}

	public void setMedidaEstandar(String medidaEstandar) {
		this.medidaEstandar = medidaEstandar;
	}

	public List<Producto> getProducto() {
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
	}

	public CategoriaProducto getCategoriaProducto() {
		return categoriaProducto;
	}

	public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}
	
	
	
	
	@Override
	public boolean equals(Object obj) {

		if(!(obj instanceof TipoProducto)) {
			return false;
		}
		TipoProducto cp =(TipoProducto) obj;
		
		return this.id!=null&&this.id.equals((cp.getId()));
	
	}


}