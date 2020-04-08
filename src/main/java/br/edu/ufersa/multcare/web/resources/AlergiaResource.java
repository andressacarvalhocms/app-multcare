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

import br.edu.ufersa.multcare.persistence.entities.Alergia;
import br.edu.ufersa.multcare.persistence.repositories.AlergiaRepository;


	@RestController
	@RequestMapping(value="/api")
	public class AlergiaResource {
		
		@Autowired
		AlergiaRepository alergiaRepository;
		
		@GetMapping("/alergia")
		public List<Alergia> listaAlergia(){
			return alergiaRepository.findAll();
		}
		
		
		@GetMapping("/alergia/{id}")
		public Alergia listaAlergiaUnico(@PathVariable(value="id") long id){
			return alergiaRepository.findById(id);
		}

/*		@GetMapping("/alergia/nome/{nome}")
		public Alergia listaExamesCreatinina(@PathVariable(value="nome") String nome){
			return exameRepository.findByNome(nome);
		} 
*/
		@PostMapping("/alergia")
		public Alergia salvaAlergia(@RequestBody Alergia alergia) {
			return alergiaRepository.save(alergia);
		}
		
		@DeleteMapping("/alergia")
		public void deletaAlergia(@RequestBody Alergia alergia) {
			alergiaRepository.delete(alergia);
		}
		
		@PutMapping("/alergia")
		public Alergia atualizaAlergia(@RequestBody Alergia alergia) {
			return alergiaRepository.save(alergia);
		}
	}