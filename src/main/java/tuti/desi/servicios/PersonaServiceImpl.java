package tuti.desi.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		if (filter.getNombre() == null && filter.getDniCuit() == null && filter.getCiudadSeleccionada() == null) {
			return repo.findAll();
		}
		return repo.filter(filter.getNombre(), filter.getDniCuit(), filter.getCiudadSeleccionada());
	}

	@Override
	public void save(Persona persona) throws Excepcion {
		boolean dniCuitDuplicado = persona.getId() == null
				? repo.existsByDniCuit(persona.getDniCuit())
				: repo.existsByDniCuitAndIdNot(persona.getDniCuit(), persona.getId());

		if (dniCuitDuplicado) {
			throw new Excepcion("Ya existe una persona con el mismo DNI/CUIT", "dniCuit");
		}

		if (persona.getId() != null && !repo.existsById(persona.getId())) {
			throw new EntidadNoEncontradaException("la persona", persona.getId());
		}

		repo.save(persona);
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
