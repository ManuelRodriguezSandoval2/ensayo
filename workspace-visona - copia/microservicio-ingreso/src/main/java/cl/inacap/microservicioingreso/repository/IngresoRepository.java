package cl.inacap.microservicioingreso.repository;

import org.springframework.data.repository.CrudRepository;

import cl.inacap.microservicio.ingreso.entity.Ingreso;

public interface IngresoRepository extends CrudRepository<Ingreso, Long> {

}
