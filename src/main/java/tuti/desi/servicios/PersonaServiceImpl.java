package tuti.desi.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tuti.desi.accesoDatos.IPersonaRepo;
import tuti.desi.entidades.Persona;
import tuti.desi.excepciones.EntidadNoEncontradaException;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.presentacion.personas.PersonasBuscarForm;

@Service
public class PersonaServiceImpl implements PersonaService {

	
	@Autowired
	IPersonaRepo repo;
	
	@Override
	public List<Persona> getAll() {
		
		return repo.findAll();
	}

	@Override
	public List<Persona> filter(PersonasBuscarForm filter) {
		//ver https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
		if(filter.getNombre()==null && filter.getDni()==null && filter.getCiudadSeleccionada()==null)
			return repo.findAll();
		else
			return repo.filter(filter.getNombre(), filter.getDni(), filter.getCiudadSeleccionada());
		
		
		
	}

	@Override
	public void save(Persona persona, Long dniOriginal) throws Excepcion {
		if (dniOriginal == null)  
		{
			//es un alta
			if (repo.existsById(persona.getDni())) {
				throw new Excepcion("Ya existe una persona con el mismo DNI", "dni");
			}
			else
			repo.save(persona);
			return;
		}
		else
		{
			//es edicion
			repo.save(persona);
		}

	}

	@Override
	public Persona getPersonaById(Long idPersona) {
		return repo.findById(idPersona)
				.orElseThrow(() -> new EntidadNoEncontradaException("la persona", idPersona));
	}

	@Override
	public void deletePersonaByid(Long id) {
		if (!repo.existsById(id)) {
			throw new EntidadNoEncontradaException("la persona", id);
		}
		repo.deleteById(id);
		
	}

	
}
