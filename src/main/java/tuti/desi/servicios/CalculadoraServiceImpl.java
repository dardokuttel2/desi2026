package tuti.desi.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraServiceImpl implements CalculadoraService{


	@Override
	public Double calcular(String action, Double n1, Double n2) {
    	switch (action) {
	      case "sumar":
	    	  return n1 + n2;
	      case "restar":
	    	  return n1 - n2;
	      case "multiplicar":
	    	  return n1 * n2;
	      case "dividir":
	          return n1 / n2;
	          
	        
    	}
    	return null;
	}

}
