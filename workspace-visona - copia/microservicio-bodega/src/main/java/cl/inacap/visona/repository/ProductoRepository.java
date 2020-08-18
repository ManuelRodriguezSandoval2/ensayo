package cl.inacap.visona.repository;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import cl.inacap.visona.entity.Producto;



@EnableJpaRepositories
public interface ProductoRepository extends PagingAndSortingRepository<Producto, Long> {
	
	
	@Query("SELECT new Producto(p.id, p.nombreProducto) FROM Producto p")
	public List<Producto>findByNombreAndId();
	
	Page<Producto> findByTipoProductoId(Long tipoProductoId, Pageable pageable);
   

}
