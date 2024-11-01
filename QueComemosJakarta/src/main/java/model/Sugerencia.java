package model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Sugerencia {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false)
	private String tipo;

	@Column(nullable = false)
	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fecha;

	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;
	
	 public Sugerencia(String tipo, String descripcion, Date fecha, Usuario usuario) {
	        this.tipo = tipo;
	        this.descripcion = descripcion;
	        this.fecha = fecha;
	        this.usuario = usuario;
	    }
}
