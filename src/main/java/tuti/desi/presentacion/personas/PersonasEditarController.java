package tuti.desi.presentacion.personas;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import tuti.desi.entidades.Persona;
import tuti.desi.entidades.Ciudad;
import tuti.desi.excepciones.Excepcion;
import tuti.desi.servicios.CiudadService;
import tuti.desi.servicios.PersonaService;


@Controller
@RequestMapping("/personasEditar")
public class PersonasEditarController {
	@Autowired
    private PersonaService service;
	@Autowired
	private CiudadService serviceCiudad;
     
    @RequestMapping(path = {"", "/{id}"},method=RequestMethod.GET)
    public String preparaForm(Model modelo, @PathVariable("id") Optional<Long> id) {
        if (id.isPresent()) {
            Persona entity = service.getPersonaById(id.get());
    		PersonaForm form = new PersonaForm(entity);
			modelo.addAttribute("formBean", form);
		} else {
 
	       modelo.addAttribute("formBean",new PersonaForm());
		}
       return "personasEditar";
    }

    @ModelAttribute("allCiudades")
    public List<Ciudad> getAllCiudades() {
        return serviceCiudad.getAll();
    }
     
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.POST)
	public String deletePersonaById(Model model, @PathVariable("id") Long id) 
	{
		service.deletePersonaByid(id);
		return "redirect:/personasBuscar";
	}
 
    
    @RequestMapping( method=RequestMethod.POST)
    public String submit(@ModelAttribute("formBean") @Valid  PersonaForm formBean,BindingResult result, ModelMap modelo,@RequestParam String action) {
    	
    	
    	if(action.equals("Aceptar"))
    	{
    		
    		if(result.hasErrors())
    		{
    			
                
    			modelo.addAttribute("formBean",formBean);
    			 return "personasEditar";
    		}
    		else
    		{
                try {
                    Persona p=formBean.toPojo();
                    if (formBean.getIdCiudad() != null) {
                        p.setCiudad(serviceCiudad.getById(formBean.getIdCiudad()));
                    }
                    service.save(p);
                    return "redirect:/personasBuscar";
                } catch (Excepcion e) {
                    if (e.getAtributo() == null) {
                        result.addError(new ObjectError("globalError", e.getMessage()));
                    } else {
                        result.addError(new FieldError("formBean", e.getAtributo(), e.getMessage()));
                    }
                    modelo.addAttribute("formBean", formBean);
                    return "personasEditar";
                }
    		}

    		
        	
        	
    	}
    
    	
    	if(action.equals("Cancelar"))
    	{
    		modelo.clear();
    		return "redirect:/personasBuscar";
    	}
    		
    	return "redirect:/";
    	
    	
    }

 
}
