package br.edu.ufersa.multcare.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter @Setter @ToString
public class Exame  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String resultado;
	private Date dataCadastro;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Usuario usuario;

}
