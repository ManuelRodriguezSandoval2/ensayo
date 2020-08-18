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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="CATEGORIA_PRODUCTO")
public class CategoriaProducto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="ID_CATEGORIA")
	private Long id;
	
	@Column(name="NOMBRE_CATEGORIA")
	private String nombreCategoria;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "categoriaProducto")
	private List<TipoProducto>tipoProducto;
	
	public CategoriaProducto() {
		
		this.tipoProducto=new ArrayList<>();
		
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}	
	
	public List<TipoProducto> getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(List<TipoProducto> tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	public void addTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto.add(tipoProducto);
	}
	public void removeTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto.remove(tipoProducto);
	}
	
	
	
	
	@Override
	public boolean equals(Object obj) {

		if(!(obj instanceof CategoriaProducto)) {
			return false;
		}
		CategoriaProducto cp =(CategoriaProducto) obj;
		
		return this.id!=null&&this.id.equals((cp.getId()));
	
	}
	
}
