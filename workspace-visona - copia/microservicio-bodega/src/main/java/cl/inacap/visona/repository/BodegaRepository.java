package cl.inacap.visona.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import cl.inacap.visona.entity.Bodega;

@EnableJpaRepositories
public interface BodegaRepository extends PagingAndSortingRepository<Bodega, Long> {
	
	@Query( "SELECT new Bodega(b.id, b.nombreBodega) FROM Bodega b")
	public List<Bodega> findByNombre();
	
	@Query( "SELECT bo FROM Bodega bo where bo.id= :id")
	public Bodega findBodegaById(@Param("id") Long id);

}
