package tuti.desi.accesoDatos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tuti.desi.entidades.Persona;

@Repository
public interface IPersonaRepo extends JpaRepository<Persona, Long> {

	@Query("""
			SELECT p FROM Persona p
			WHERE (:nombre IS NULL OR LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombre, '%')))
			  AND (:dni IS NULL OR p.dni = :dni)
			  AND (:idCiudad IS NULL OR p.ciudad.id = :idCiudad)
			""")
	List<Persona> filter(
			@Param("nombre") String nombre,
			@Param("dni") Long dni,
			@Param("idCiudad") Long idCiudad);
	
}
