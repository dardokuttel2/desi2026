package tuti.desi.presentacion.caluladora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tuti.desi.servicios.CalculadoraService;


@Controller
@RequestMapping("/calculadora")
public class CalculadoraController {

	@Autowired
	private CalculadoraService servicio;
	
	
    @RequestMapping(method=RequestMethod.GET)
    public String preparaForm(Model modelo) {
    	modelo.addAttribute("formBean",new CalculadoraModel());
       return "calculadora";
    }
     
    
   
    @RequestMapping( method=RequestMethod.POST)
    public String submit( @ModelAttribute("formBean") CalculadoraModel  formBean,BindingResult result, ModelMap modelo,@RequestParam String action){
    	

        Double n1 = formBean.getA();
        Double n2 = formBean.getB();
//    	switch (action) {
//            case "sumar":
//                formBean.setResultado(n1 + n2);
//                break;
//            case "restar":
//                formBean.setResultado(n1 - n2);
//                break;
//            case "multiplicar":
//                formBean.setResultado(n1 * n2);
//                break;
//            case "dividir":
//                formBean.setResultado(n1 / n2);
//                break;
//        }
        formBean.setResultado(servicio.calcular(action, n1,n2));
    		
    	return "calculadora";
    	
    	
    }

 
}
