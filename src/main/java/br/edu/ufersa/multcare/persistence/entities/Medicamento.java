package br.edu.ufersa.multcare.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter @Setter @ToString
public class Medicamento  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String hora;
	private Date dataInicial;
	private Date dataFinal;
	private int quantidadeDiaria;
	private int totalMedicamento;
	private String tipo;
	private String status;
	private int frequencia;
	private Date dataCadastro;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Usuario usuario;

}
