package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fecha;

	@Column(nullable = false)
	private Float monto;

	@Column(nullable = false)
	private String estado;

	
	  @ManyToMany
	  
	  @JoinTable(name = "pedido_menu", joinColumns = @JoinColumn(name =
	  "pedido_id"), inverseJoinColumns = @JoinColumn(name = "menu_id")) 
	  private List<Menu> menus;
	  
	  @ManyToMany(cascade = CascadeType.REMOVE)
	  
	  @JoinTable(name = "pedido_comida", joinColumns = @JoinColumn(name =
	  "pedido_id"), inverseJoinColumns = @JoinColumn(name = "comida_id")) 
	  private List<Comida> comidas;
	  
	  @ManyToOne
	  @JoinColumn(name = "usuario_id", nullable = false)
	  private Usuario usuario;
	  
	  public Pedido(Date fecha, List<Menu> menus, List<Comida> comidas, Usuario usuario) {
		// Validación: Asegurarse que el usuario no sea nulo
	        Objects.requireNonNull(usuario, "El usuario es obligatorio para un pedido");
		  	this.fecha = fecha;
	        this.menus = menus != null ? menus : new ArrayList<>();
	        this.comidas = comidas != null ? comidas : new ArrayList<>();
	        this.usuario = usuario;
	        this.monto = calcularMontoTotal();
	        this.estado = "PENDIENTE"; // o cualquier estado inicial
	    }
	  
	  private Float calcularMontoTotal() {
	        float montoTotal = 0;
	        for (Menu menu : menus) {
	            montoTotal += menu.getPrecio();
	        }
	        for (Comida comida : comidas) {
	            montoTotal += comida.getPrecio();
	        }
	        return montoTotal;
	    }

	 
}
