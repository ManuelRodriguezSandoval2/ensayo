package cl.inacap.visona.entity;




import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="PROVEEDOR")
public class Proveedor  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name="ID_PROVEEDOR")	
	private Long id;
	
	@Column(name="RAZON_SOCIAL")	
	private String razonSocial;
	
	@Column(name="RUT")	
	private String rut;
	
	@Column(name="DIRECCION")	
	private String direccion;
	
	@Column(name="CIUDAD")	
	private String ciudad;
	
	@Column(name="EMAIL")	
	private String email;
	
	@Column(name="GIRO")	
	private String giro;
	
	@JsonIgnore
	@OneToMany(mappedBy = "proveedor")
	private List<Existencias>existencia;
	
	
	public Proveedor() {
		this.existencia=new ArrayList<>();
	}
	
	public Proveedor(Long id, String razonSocial) {
		this.id =  id;
		this.razonSocial = razonSocial;
		
	}

	/*
	@JsonCreator
	public Proveedor(Long id, String razonSocial, String rut, String direccion, String ciudad, String email,
			String giro, List<Existencias> existencia) {
		super();
		this.id = id;
		this.razonSocial = razonSocial;
		this.rut = rut;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.email = email;
		this.giro = giro;
		this.existencia = existencia;
	}
*/



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
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGiro() {
		return giro;
	}
	public void setGiro(String giro) {
		this.giro = giro;
	}
	
	
	
	
	
	@Override
	public boolean equals(Object obj) {

		if(!(obj instanceof Proveedor)) {
			return false;
		}
		Proveedor cp =(Proveedor) obj;
		
		return this.id!=null&&this.id.equals((cp.getId()));
	
	}
	
	
}

