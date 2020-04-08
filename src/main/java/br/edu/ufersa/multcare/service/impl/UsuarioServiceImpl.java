package br.edu.ufersa.multcare.service.impl;

import br.edu.ufersa.multcare.persistence.entities.Usuario;
import br.edu.ufersa.multcare.persistence.repositories.UsuarioRepository;
import br.edu.ufersa.multcare.service.UsuarioService;
import br.edu.ufersa.multcare.shared.builder.UsuarioBuilder;
import br.edu.ufersa.multcare.shared.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static br.edu.ufersa.multcare.auth.UserJWTController.passwordHash;


@Component
public class UsuarioServiceImpl implements UsuarioService {


    @Autowired
    private UsuarioRepository usuariosRepository;

    @Override
    public String cadastrarUsuario(UsuarioDTO usuarioDTO) {

        validarSeJaExisteUsuario(usuarioDTO);
        Usuario usuario = usuariosRepository.save(obterUsuario(usuarioDTO));

        if(usuario != null) {
            return "Usuário " + usuario.getNome() + " cadastrado com sucesso!";
        }

        return null;
    }

    @Override
    public Usuario obterUsuarioPorLogin(String login) {
        return usuariosRepository.findUsuarioByLoginEquals(login);
    }

    @Override
    public Usuario obterUsuarioPorNome(String nome) {
        return usuariosRepository.findUsuarioByNomeEquals(nome);
    }

    private void validarSeJaExisteUsuario(UsuarioDTO usuarioDTO) {

        Usuario user = usuariosRepository.findUsuarioByNomeEqualsAndLoginEquals(usuarioDTO.getNome(), usuarioDTO.getLogin());
        if (user != null) {
            throw new RuntimeException("Usuário já existente");
        }
    }


    private Usuario obterUsuario(UsuarioDTO usuarioDTO) {

        return UsuarioBuilder.of()
                .comNome(usuarioDTO.getNome())
                .comLogin(usuarioDTO.getLogin())
                .comIdade(usuarioDTO.getIdade())
                .comPeso(usuarioDTO.getPeso())
                .comSenha(passwordHash(usuarioDTO.getSenha()))
                .comSexo(usuarioDTO.getSexo())
                .build();
    }
}
