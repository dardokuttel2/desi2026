package tuti.desi.servicios;

import java.util.List;

import tuti.desi.entidades.Persona;
import tuti.desi.presentacion.personas.PersonasBuscarForm;

public interface PersonaService {



	List<Persona> getAll();

	List<Persona> filter(PersonasBuscarForm filter);

	/**
	 * Si la persona existe la actualizará, sino la creará en BD
	 * @param persona
	 */
	void save(Persona persona);

	/**
	 * permite obtener una persona determinada 
	 * @param idPersona identificador de la persona buscada
	 * @return persona encontrada o null si no encontr{o la persona
	 * @throws Exception ante un error
	 */
	Persona getPersonaById(Long idPersona) throws Exception;

	void deletePersonaByid(Long id);

	
}
