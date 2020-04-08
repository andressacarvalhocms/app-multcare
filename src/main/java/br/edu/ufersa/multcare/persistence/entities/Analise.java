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
public class Analise implements IEntity {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String situacao;
	private Date dataCadastro;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Usuario usuario;

}
