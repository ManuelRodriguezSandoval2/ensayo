package cl.inacap.visona.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cl.inacap.visona.entity.Producto;

public interface ProductoService {

	public Iterable<Producto> finAll();

	public Page<Producto> findAll(Pageable pageable);

	public Optional<Producto> findbyId(Long id);

	public Producto save(Producto producto);

	public List<Producto> findByNombreAndId();

	public boolean deleteById(Long id);

}
