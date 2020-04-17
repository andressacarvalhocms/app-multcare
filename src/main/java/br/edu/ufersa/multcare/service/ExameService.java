package br.edu.ufersa.multcare.service;

import br.edu.ufersa.multcare.persistence.entities.Exame;
import br.edu.ufersa.multcare.shared.exception.TipoExameNotFound;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExameService {

    List<Exame> listarExamesUsuarioLogado();

    Exame cadastrarExame(Exame exame) throws TipoExameNotFound;

    Exame atualizarExame(Exame exame);

    void deletarExame(Exame exame);
}
