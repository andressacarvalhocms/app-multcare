package br.edu.ufersa.multcare.service;

import br.edu.ufersa.multcare.persistence.entities.TipoExame;
import br.edu.ufersa.multcare.shared.exception.TipoExameNotFound;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TipoExameService {

    List<TipoExame> obterTodosTipoExame();

    TipoExame obterTipoExamePorDescricao(String descricao) throws TipoExameNotFound;
}
