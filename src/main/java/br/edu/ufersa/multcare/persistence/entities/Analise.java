package br.edu.ufersa.multcare.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter @Setter @ToString
public class Analise {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String situacao;
	private Date dataCadastro;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Usuario usuario;

}
