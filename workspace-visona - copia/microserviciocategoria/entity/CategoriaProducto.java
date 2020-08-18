package cl.inacap.microserviciocategoria.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORIA_PRODUCTO")
public class CategoriaProducto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="ID_CATEGORIA")
	private Long id;
	
	@Column(name="NOMBRE_CATEGORIA")
	private String nombreCategoria;
	
	
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

	
}
