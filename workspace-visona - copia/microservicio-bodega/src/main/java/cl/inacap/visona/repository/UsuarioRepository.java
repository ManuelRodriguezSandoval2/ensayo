package cl.inacap.visona.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import cl.inacap.visona.entity.Usuario;

@EnableJpaRepositories
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {

	@Query( "SELECT us FROM Usuario us where us.rut= :rut")
	public Usuario findUsuarioByRut(@Param("rut") String rut);
	
}
