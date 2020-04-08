package br.edu.ufersa.multcare.web.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufersa.multcare.persistence.entities.Medicamento;
import br.edu.ufersa.multcare.persistence.repositories.MedicamentoRepository;


@RestController
@RequestMapping(value="/api")
public class MedicamentoResource {
	
	@Autowired
	MedicamentoRepository medicamentoRepository;
	
	@GetMapping("/medicamento")
	public List<Medicamento> listaMedicamento(){
		return medicamentoRepository.findAll();
	}
	
	
		@GetMapping("/medicamento/{id}")
	public Medicamento listaMedicamentosUnico(@PathVariable(value="id") long id){
		return medicamentoRepository.findById(id);
	}

/*	@GetMapping("/exames/nome/{nome}")
	public Exame listaExamesCreatinina(@PathVariable(value="nome") String nome){
		return exameRepository.findByNome(nome);
	} 
*/
	@PostMapping("/medicamento")
	public Medicamento salvaMedicamento(@RequestBody Medicamento medicamento) {
		return medicamentoRepository.save(medicamento);
	}
	
	@DeleteMapping("/medicamento")
	public void deletaMedicamento(@RequestBody Medicamento medicamento) {
		medicamentoRepository.delete(medicamento);
	}
	
	@PutMapping("/medicamento")
	public Medicamento atualizaMedicamento(@RequestBody Medicamento medicamento) {
		return medicamentoRepository.save(medicamento);
	}
}