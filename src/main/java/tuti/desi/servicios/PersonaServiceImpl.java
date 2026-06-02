package tuti.desi.servicios;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuti.desi.accesoDatos.IPersonaRepo;
import tuti.desi.entidades.Persona;
import tuti.desi.presentacion.personas.PersonasBuscarForm;

@Service
public class PersonaServiceImpl implements PersonaService {

	Logger LOG = LoggerFactory.getLogger(PersonaService.class);

	
	@Autowired
	IPersonaRepo repo;
	
	@Override
	public List<Persona> getAll() {
		
		return repo.findAll();
	}

	@Override
	public List<Persona> filter(PersonasBuscarForm filter) {
		//ver https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
		if(filter.getNombre()==null && filter.getDni()==null)
			return repo.findAll();
		else
			return repo.findByNombreOrDni(filter.getNombre(),filter.getDni());
		
		
		
	}

	@Override
	public void save(Persona persona) {
		repo.save(persona);
		
	}

	@Override
	public Persona getPersonaById(Long idPersona) throws Exception {
		Optional<Persona> p = repo.findById(idPersona);
		
		if(p!=null) {
			return p.get();
		} else {
			throw new Exception("No existe la persona con el id="+idPersona);
		}
	}

	@Override
	public void deletePersonaByid(Long id) {
		repo.deleteById(id);
		
	}

	
}
