package tuti.desi.presentacion.personas;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import tuti.desi.entidades.Persona;

/**
 * Objeto necesario para insertar o eliminar una persona. 
 * Nótese que en lugar de referenciar al objeto Ciudad, reemplaza ese atributo por el idCiudad, ya que es el valor que asocia la lista seleccionable de la interfaz web
 *
 */
public class PersonaForm {

	@NotNull(message = "el dni no puede ser nulo")
	@Min(value = 7000000, message = "el dni debe ser mayor a 7000000")
	private Long dni;
	@NotNull
	@Size(min=2, max=30)
	private String apellido;
	@NotNull
	@Size(min=2, max=30)
	private String nombre;
	@NotNull
	private Long idCiudad;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Past
	private java.time.LocalDate fechaNacimiento;
	
	public PersonaForm() {
		super();
	}
	public PersonaForm(Persona p) {
		super();
		this.nombre=p.getNombre();
		this.apellido=p.getApellido();
		this.dni=p.getDni();
		this.idCiudad=p.getCiudad().getId();
		this.fechaNacimiento=p.getFechaNacimiento();
	}
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}
	
	public Persona toPojo()
	{
		Persona p = new Persona();
		p.setDni(this.getDni());
		p.setApellido(this.getApellido());
		p.setNombre(this.getNombre());
		p.setDni(this.getDni());
		p.setFechaNacimiento(this.getFechaNacimiento());
		return p;
	}
	public java.time.LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(java.time.LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
