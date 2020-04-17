package br.edu.ufersa.multcare.web.resources;

import br.edu.ufersa.multcare.persistence.entities.TipoExame;
import br.edu.ufersa.multcare.service.TipoExameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value="/api/tipoexame")
public class TipoExameResource {

    @Autowired
    private TipoExameService tipoExameService;

    @GetMapping("/todos")
    public ResponseEntity<List<TipoExame>> obterTodos() {
        List<TipoExame> tipoExames = tipoExameService.obterTodosTipoExame();
        return ResponseEntity.ok(tipoExames);
    }

}