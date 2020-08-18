package cl.inacap.visona.repository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import cl.inacap.visona.entity.Existencias;



@EnableJpaRepositories
public interface ExistenciasRepository extends PagingAndSortingRepository<Existencias, Long> {

}
