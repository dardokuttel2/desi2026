package tuti.desi.presentacion.personas;

import jakarta.validation.constraints.NotNull;

public class PersonasBuscarForm {
	@NotNull
	private Long dni;
	private String nombre;
	private String tipoDoc;
	private String ciudadSeleccionada;
	
	
//	private List<Ciudad> ciudades;

	
	public String getCiudadSeleccionada() {
		return ciudadSeleccionada;
	}
	public void setCiudadSeleccionada(String ciudadSeleccionada) {
		this.ciudadSeleccionada = ciudadSeleccionada;
	}
//	public List<Ciudad> getCiudades() {
//		return ciudades;
//	}
//	public void setCiudades(List<Ciudad> ciudades) {
//		this.ciudades = ciudades;
//	}
	public Long getDni() {
		if(dni!=null && dni>0)
			return dni;
		else
			return null;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	public String getNombre() {
		if(nombre!=null && nombre.length()>0)
			return nombre;
		else
			return null;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	

}
