package br.edu.ufersa.multcare.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufersa.multcare.persistence.entities.Exame;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Long>{

	Exame findById(long id);
	Exame findByNome(String nome);
//	Exame deleteById(int id);
	
}