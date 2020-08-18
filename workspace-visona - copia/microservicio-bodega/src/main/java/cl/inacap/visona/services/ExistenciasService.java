package cl.inacap.visona.services;

import java.util.Optional;

import org.springframework.data.domain.Pageable;

import cl.inacap.visona.entity.Existencias;

public interface ExistenciasService {

	public Iterable<Existencias>findAll(Pageable pageable);

	public Optional<Existencias> findbyId(Long id);

	public Existencias save(Existencias existencias);

	public boolean deleteById(Long id);

}
