package model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private Float precio;

	
	  // cambiar a 4 relaciones? (entrada, principal, postre, bebida)
	  
	  @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL) 
	  private List<Comida>
	  comidas;
	 

}