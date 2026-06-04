package tuti.desi.presentacion.personas;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import tuti.desi.entidades.Persona;

public class PersonaForm {

	private Long id;

	@NotBlank(message = "El nombre es obligatorio")
	@Size(max = 100)
	private String nombre;

	@NotBlank(message = "El apellido es obligatorio")
	@Size(max = 100)
	private String apellido;

	@NotBlank(message = "El DNI/CUIT es obligatorio")
	@Pattern(regexp = "\\d{7,11}", message = "El DNI/CUIT debe contener entre 7 y 11 dígitos")
	private String dniCuit;

	@NotBlank(message = "El teléfono es obligatorio")
	@Size(max = 30)
	private String telefono;

	@NotBlank(message = "El email es obligatorio")
	@Email(message = "El email no tiene un formato válido")
	@Size(max = 150)
	private String email;

	@NotBlank(message = "El domicilio es obligatorio")
	@Size(max = 200)
	private String domicilio;
	
	private Long idCiudad;

	public PersonaForm() {
	}

	public PersonaForm(Persona persona) {
		this.id = persona.getId();
		this.nombre = persona.getNombre();
		this.apellido = persona.getApellido();
		this.dniCuit = persona.getDniCuit();
		this.telefono = persona.getTelefono();
		this.email = persona.getEmail();
		this.domicilio = persona.getDomicilio();
		this.idCiudad = persona.getCiudad() == null ? null : persona.getCiudad().getId();
	}

	public Persona toPojo() {
		Persona persona = new Persona();
		persona.setId(id);
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setDniCuit(dniCuit);
		persona.setTelefono(telefono);
		persona.setEmail(email);
		persona.setDomicilio(domicilio);
		return persona;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDniCuit() {
		return dniCuit;
	}

	public void setDniCuit(String dniCuit) {
		this.dniCuit = dniCuit;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Long getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}
}
