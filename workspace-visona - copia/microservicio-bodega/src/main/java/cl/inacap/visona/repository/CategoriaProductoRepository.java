package cl.inacap.visona.repository;




import java.util.List;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import cl.inacap.visona.entity.CategoriaProducto;




@EnableJpaRepositories
public interface CategoriaProductoRepository extends PagingAndSortingRepository<CategoriaProducto, Long> {
	
	//@Query("select a from CategoriaProducto a where a.nombreCategoria like %?1% ")
	public List<CategoriaProducto>findByNombreCategoria(String term);

}
