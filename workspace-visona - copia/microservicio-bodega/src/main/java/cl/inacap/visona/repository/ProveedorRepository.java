package cl.inacap.visona.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import cl.inacap.visona.entity.Proveedor;

@EnableJpaRepositories
public interface ProveedorRepository extends PagingAndSortingRepository<Proveedor, Long> {

	
	@Query( "SELECT new Proveedor(p.id, p.razonSocial) FROM Proveedor p")
	public List<Proveedor> findByNombre();
	
	@Query( "SELECT pr FROM Proveedor pr where pr.rut= :rut")
	public Proveedor findProveedorByRut(@Param("rut") String rut);
	
	
}
