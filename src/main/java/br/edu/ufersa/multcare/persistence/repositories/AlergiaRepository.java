package br.edu.ufersa.multcare.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufersa.multcare.persistence.entities.Alergia;


@Repository
public interface AlergiaRepository extends JpaRepository<Alergia, Long>{

	Alergia findById(long id);
	Alergia findByNome(String nome);
//	Exame deleteById(int id);
	

}