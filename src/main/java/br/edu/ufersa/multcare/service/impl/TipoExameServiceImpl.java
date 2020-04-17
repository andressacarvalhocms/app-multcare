package br.edu.ufersa.multcare.service.impl;

import br.edu.ufersa.multcare.persistence.entities.TipoExame;
import br.edu.ufersa.multcare.persistence.repositories.TipoExameRepository;
import br.edu.ufersa.multcare.service.TipoExameService;
import br.edu.ufersa.multcare.shared.exception.TipoExameNotFound;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TipoExameServiceImpl implements TipoExameService {

    private final TipoExameRepository tipoExameRepository;

    public TipoExameServiceImpl(TipoExameRepository tipoExameRepository) {
        this.tipoExameRepository = tipoExameRepository;
    }

    @Override
    public List<TipoExame> obterTodosTipoExame() {
        return tipoExameRepository.findAll();
    }

    @Override
    public TipoExame obterTipoExamePorDescricao(String descricao) throws TipoExameNotFound {
        Optional<TipoExame> tipoExame = tipoExameRepository.findTipoExameByDescricaoEquals(descricao);
        return tipoExame.orElseThrow(TipoExameNotFound::new);
    }
}
