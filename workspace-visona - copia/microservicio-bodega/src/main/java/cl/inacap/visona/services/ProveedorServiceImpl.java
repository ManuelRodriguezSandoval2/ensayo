package cl.inacap.visona.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.inacap.visona.entity.Proveedor;
import cl.inacap.visona.repository.ProveedorRepository;

@Service
public class ProveedorServiceImpl implements ProveedorService {

	@Autowired
	private ProveedorRepository repository;

	@Transactional(readOnly = true)
	@Override
	public Iterable<Proveedor> findAll(Pageable pageable) {

		return repository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Proveedor> findbyId(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);

	}

	@Override
	@Transactional
	public Proveedor save(Proveedor proveedor) {
		Proveedor proveedorRut = this.repository.findProveedorByRut(proveedor.getRut());

		if (proveedorRut == null) {
			return repository.save(proveedor);

		}
		return null;
	}

	@Override
	@Transactional
	public boolean deleteById(Long id) {

		Optional<Proveedor> usuarioOP = this.repository.findById(id);

		if (usuarioOP.isPresent()) {

			repository.deleteById(id);
			return true;
		}
		return false;

	}

	@Override
	@Transactional(readOnly = true)
	public List<Proveedor> findByNombre() {

		return repository.findByNombre();
	}

}
