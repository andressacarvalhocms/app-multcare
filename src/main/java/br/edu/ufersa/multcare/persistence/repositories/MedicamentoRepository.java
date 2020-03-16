package br.edu.ufersa.multcare.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufersa.multcare.persistence.entities.Medicamento;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long>{

	Medicamento findById(long id);
	Medicamento findByNome(String nome);
//	
}
