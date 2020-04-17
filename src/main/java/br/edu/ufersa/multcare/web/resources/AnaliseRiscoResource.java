package br.edu.ufersa.multcare.web.resources;

import br.edu.ufersa.multcare.service.AnaliseDeRiscoDeDRCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/api/analise")
public class AnaliseRiscoResource {

	@Autowired
	private AnaliseDeRiscoDeDRCService analiseDeRiscoDeDRCService;

	@GetMapping("/realizar")
	public ResponseEntity<Boolean> realizarAnaliseRisco() throws Exception {

		analiseDeRiscoDeDRCService.realizarClassificacaoAnalise();
		return ResponseEntity.ok(Boolean.TRUE);
	}
}