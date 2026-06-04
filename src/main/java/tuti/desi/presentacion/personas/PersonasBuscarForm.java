package tuti.desi.presentacion.personas;

public class PersonasBuscarForm {
	private Long dni;
	private String nombre;
	private Long ciudadSeleccionada;
	
	
//	private List<Ciudad> ciudades;

	
	public Long getCiudadSeleccionada() {
		return ciudadSeleccionada;
	}
	public void setCiudadSeleccionada(Long ciudadSeleccionada) {
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
}
