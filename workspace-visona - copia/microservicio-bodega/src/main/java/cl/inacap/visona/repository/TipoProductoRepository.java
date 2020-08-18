package cl.inacap.visona.repository;


import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;


import cl.inacap.visona.entity.TipoProducto;





@EnableJpaRepositories
public interface TipoProductoRepository extends CrudRepository<TipoProducto, Long> {

}
