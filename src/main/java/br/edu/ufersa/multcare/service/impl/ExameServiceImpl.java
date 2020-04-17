package br.edu.ufersa.multcare.service.impl;

import br.edu.ufersa.multcare.persistence.entities.Exame;
import br.edu.ufersa.multcare.persistence.entities.TipoExame;
import br.edu.ufersa.multcare.persistence.entities.Usuario;
import br.edu.ufersa.multcare.persistence.repositories.ExameRepository;
import br.edu.ufersa.multcare.service.ExameService;
import br.edu.ufersa.multcare.service.TipoExameService;
import br.edu.ufersa.multcare.service.UsuarioService;
import br.edu.ufersa.multcare.shared.exception.TipoExameNotFound;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static br.edu.ufersa.multcare.security.SecurityUtils.obterIdUsuarioAutenticado;

@Component
public class ExameServiceImpl implements ExameService {

    private final ExameRepository exameRepository;

    private final UsuarioService usuarioService;

    private final TipoExameService tipoExameService;

    public ExameServiceImpl(ExameRepository exameRepository, UsuarioService usuarioService, TipoExameService tipoExameService) {
        this.exameRepository = exameRepository;
        this.usuarioService = usuarioService;
        this.tipoExameService = tipoExameService;
    }

    @Override
    public List<Exame> listarExamesUsuarioLogado() {
        return exameRepository.listarExamesUsuario(obterIdUsuarioAutenticado());
    }

    @Override
    public Exame cadastrarExame(Exame exame) throws TipoExameNotFound {
        Usuario usuario = usuarioService.obterUsuarioPorId(obterIdUsuarioAutenticado());
        TipoExame tipoExame = determinarTipoExamePorDescricao(exame);
        exame.setUsuario(usuario);
        exame.setDataCadastro(new Date());
        exame.setTipoExame(tipoExame);

        return exameRepository.save(exame);
    }

    @Override
    public Exame atualizarExame(Exame exame) {
        return exameRepository.save(exame);
    }

    @Override
    public void deletarExame(Exame exame) {
        exameRepository.delete(exame);
    }

    private TipoExame determinarTipoExamePorDescricao(Exame exame) throws TipoExameNotFound {
        return tipoExameService.obterTipoExamePorDescricao(exame.getNome());
    }

}
