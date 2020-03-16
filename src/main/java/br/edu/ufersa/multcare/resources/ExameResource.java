package br.edu.ufersa.multcare.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufersa.multcare.persistence.entities.Exame;
import br.edu.ufersa.multcare.persistence.repositories.ExameRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST EXAMES")
@CrossOrigin(origins="*")
public class ExameResource {
	
	@Autowired
	ExameRepository exameRepository;
	
	@GetMapping("/exames")
	@ApiOperation(value="Retorna uma lista de exames")
	public List<Exame> listaExames(){
		return exameRepository.findAll();
	}
	
	
	@GetMapping("/exames/{id}")
	@ApiOperation(value="Retorna um exame")
	public Exame listaExamesUnico(@PathVariable(value="id") long id){
		return exameRepository.findById(id);
	}

	@GetMapping("/exames/nome/{nome}")
	public Exame listaExamesCreatinina(@PathVariable(value="nome") String nome){
		return exameRepository.findByNome(nome);
	} 

	@PostMapping("/exames")
	@ApiOperation(value="salva um exame")
	public Exame salvaExame(@RequestBody Exame exame) {
		return exameRepository.save(exame);
	}
	
	@DeleteMapping("/exames")
	@ApiOperation(value="deleta um exame")
	public void deletaExame(@RequestBody Exame exame) {
		exameRepository.delete(exame);
	}
	
	@PutMapping("/exames")
	@ApiOperation(value="altera um exame")
	public Exame atualizaExame(@RequestBody Exame exame) {
		return exameRepository.save(exame);
	}
}