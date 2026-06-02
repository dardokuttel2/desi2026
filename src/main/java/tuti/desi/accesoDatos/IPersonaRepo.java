package tuti.desi.accesoDatos;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tuti.desi.entidades.Persona;

@Repository
public interface IPersonaRepo extends JpaRepository<Persona, Long> {

	@Query("SELECT p FROM Persona p WHERE p.nombre like ?1")
	Collection<Persona> findPersonasConLetra(String letra);
	
	List<Persona> findByNombreOrDni( String nombre, Long dni);
	
}
