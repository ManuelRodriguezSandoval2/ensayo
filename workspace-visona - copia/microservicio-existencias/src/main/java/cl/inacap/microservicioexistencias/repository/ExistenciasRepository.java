package cl.inacap.microservicioexistencias.repository;

import org.springframework.data.repository.CrudRepository;


import cl.inacap.microservicioexistencias.entity.Existencias;

public interface ExistenciasRepository extends CrudRepository<Existencias, Long> {

}
