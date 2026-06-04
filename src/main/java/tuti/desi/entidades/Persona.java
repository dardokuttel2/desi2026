package tuti.desi.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 1,max = 100, message = "El nombre es obligatorio")
	private String nombre;

	@Size(min = 1,max = 100, message = "El apellido es obligatorio")
	private String apellido;

	@NotBlank(message = "El DNI/CUIT es obligatorio")
	@Pattern(regexp = "\\d{7,11}", message = "El DNI/CUIT debe contener entre 7 y 11 dígitos")
	@Column(nullable = false, unique = true, length = 11)
	private String dniCuit;

	@Size(min = 1,max = 30, message = "El teléfono es obligatorio")
	private String telefono;

	@Email(message = "El email no tiene un formato válido")
	@Size(max = 150)
	private String email;

	@Size(min = 1,max = 200, message = "El domicilio es obligatorio")
	private String domicilio;
	
	@ManyToOne
	private Ciudad ciudad;
	

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
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
}
