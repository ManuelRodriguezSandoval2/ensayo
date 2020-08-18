package cl.inacap.visona.repository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;

import cl.inacap.visona.entity.Traspasos;



@EnableJpaRepositories
public interface TraspasosRepository extends PagingAndSortingRepository<Traspasos, Long> {

}
