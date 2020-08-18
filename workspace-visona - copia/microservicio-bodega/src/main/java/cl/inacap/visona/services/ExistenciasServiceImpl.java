package cl.inacap.visona.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.inacap.visona.entity.Bodega;
import cl.inacap.visona.entity.Existencias;
import cl.inacap.visona.entity.Producto;
import cl.inacap.visona.entity.Proveedor;
import cl.inacap.visona.entity.Traspasos;
import cl.inacap.visona.repository.ExistenciasRepository;

@Service
public class ExistenciasServiceImpl implements ExistenciasService {

	@Autowired
	private ExistenciasRepository repository;

	@Autowired
	private TraspasosService traspasosService;

	@Autowired
	private ProveedorService proveedorService;

	@Autowired
	private BodegaService bodegaService;
	
	@Autowired
	private ProductoService productoService;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Existencias> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return repository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Existencias> findbyId(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);

	}

	@Override
	@Transactional
	public Existencias save(Existencias existencias) {

//		traspasosService
		Existencias existencia = repository.save(existencias);
		if (null != existencia) {
			Traspasos traspasos = new Traspasos();

			Optional<Proveedor> proveedor = proveedorService.findbyId(existencia.getProveedor().getId());
			Optional<Bodega> bodega = bodegaService.findbyId(existencia.getBodega().getId());
			Optional<Producto> producto = productoService.findbyId(existencia.getProducto().getId());

			if (proveedor.isPresent()) {

				traspasos.setBodegaEntrante(proveedor.get().getRazonSocial());

			}
			if (bodega.isPresent()) {

				traspasos.setBodegaSaliente(bodega.get().getNombreBodega());

			}
			if (producto.isPresent()) {

				traspasos.setMedidaEstandar(producto.get().getNombreProducto());

			}

			traspasos.setCantidad(existencia.getStock());
			traspasos.setFechaTraspaso(existencia.getFechaIngreso());

			traspasosService.save(traspasos);
		}
		return existencia;
	}

	@Override
	@Transactional
	public boolean deleteById(Long id) {

		Optional<Existencias> existenciaOP = this.repository.findById(id);

		if (existenciaOP.isPresent()) {

			repository.deleteById(id);
			return true;
		}
		return false;

	}

}
