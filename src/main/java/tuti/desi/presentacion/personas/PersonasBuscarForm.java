package tuti.desi.presentacion.personas;

public class PersonasBuscarForm {

	private String dniCuit;
	private String nombre;
	private Long ciudadSeleccionada;

	public String getDniCuit() {
		return normalizar(dniCuit);
	}

	public void setDniCuit(String dniCuit) {
		this.dniCuit = dniCuit;
	}

	public String getNombre() {
		return normalizar(nombre);
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCiudadSeleccionada() {
		return ciudadSeleccionada;
	}

	public void setCiudadSeleccionada(Long ciudadSeleccionada) {
		this.ciudadSeleccionada = ciudadSeleccionada;
	}

	private String normalizar(String valor) {
		return valor == null || valor.isBlank() ? null : valor.trim();
	}
}
