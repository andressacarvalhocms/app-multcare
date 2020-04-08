package br.edu.ufersa.multcare.persistence.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.edu.ufersa.multcare.persistence.interfaces.IEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
public class Alergia implements IEntity {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String gravidade;
	private Date dataCadastro;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Usuario usuario;

}
