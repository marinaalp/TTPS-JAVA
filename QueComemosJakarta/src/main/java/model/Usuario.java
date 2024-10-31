package model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false, unique = true)
	private String dni;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private String apellido;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String clave;

	private String foto;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL) private
	List<Sugerencia> sugerencias;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL) private
	List<Pedido> pedidos;
	
	@ManyToOne
	@JoinColumn(name = "rol_id", nullable = false)
	private Rol rol;
	
	public Usuario(String dni, String nombre, String apellido, String email, String clave, String foto, Rol rol) {
		this.dni = dni;
	    this.nombre = nombre;
	    this.apellido = apellido;
	    this.email = email;
	    this.clave = clave;
	    this.foto = foto;
	    this.rol = rol;
	}
}
