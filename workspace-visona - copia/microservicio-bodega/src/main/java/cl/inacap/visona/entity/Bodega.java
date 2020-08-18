package cl.inacap.visona.entity;


import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name="BODEGA")
public class Bodega {

	
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="ID_BODEGA")
	private Long id;
	
	@Column(name="NOMBRE_BODEGA")
	private String nombreBodega;
	
	@Column(name="CIUDAD")
	private String ciudad;
	
	@Column(name="DIRECCION")
	private String direccion;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "bodega")
	private List<Existencias>existencias;
	
	public Bodega() {
		this.existencias=new ArrayList<>();
		
	}
	
	
	public Bodega(Long id, String nombreBodega) {
		this.id = id;
		this.nombreBodega = nombreBodega;
	}
	



	public Bodega(Long id, String nombreBodega, String ciudad, String direccion, List<Existencias> existencias) {
		super();
		this.id = id;
		this.nombreBodega = nombreBodega;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.existencias = existencias;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreBodega() {
		return nombreBodega;
	}

	public void setNombreBodega(String nombreBodega) {
		this.nombreBodega = nombreBodega;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	

	
	
	
	
	
	
	public List<Existencias> getExistencias() {
		return existencias;
	}

	public void setExistencias(List<Existencias> existencias) {
		this.existencias = existencias;
	}
	public void addExistencias(Existencias existencias) {
		this.existencias.add(existencias);
	}
	public void removeExistencias(Existencias existencias) {
		this.existencias.remove(existencias);
	}
	
	
	
	
	
	

	@Override
	public boolean equals(Object obj) {

		if(!(obj instanceof Bodega)) {
			return false;
		}
		Bodega cp =(Bodega) obj;
		
		return this.id!=null&&this.id.equals((cp.getId()));
	
	}
	
	
	
	


}
