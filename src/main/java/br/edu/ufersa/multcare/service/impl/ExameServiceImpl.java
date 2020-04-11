package br.edu.ufersa.multcare.service.impl;

import br.edu.ufersa.multcare.persistence.entities.Exame;
import br.edu.ufersa.multcare.persistence.entities.Usuario;
import br.edu.ufersa.multcare.persistence.repositories.ExameRepository;
import br.edu.ufersa.multcare.service.ExameService;
import br.edu.ufersa.multcare.service.UsuarioService;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static br.edu.ufersa.multcare.security.SecurityUtils.obterIdUsuarioAutenticado;

@Component
public class ExameServiceImpl implements ExameService {

    private final ExameRepository exameRepository;

    private final UsuarioService usuarioService;

    public ExameServiceImpl(ExameRepository exameRepository, UsuarioService usuarioService) {
        this.exameRepository = exameRepository;
        this.usuarioService = usuarioService;
    }

    @Override
    public List<Exame> listarExamesUsuarioLogado() {
        return exameRepository.listarExamesUsuario(obterIdUsuarioAutenticado());
    }

    @Override
    public Exame cadastrarExame(Exame exame) {
        Usuario usuario = usuarioService.obterUsuarioPorId(obterIdUsuarioAutenticado());
        exame.setUsuario(usuario);
        exame.setDataCadastro(new Date());

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

}
