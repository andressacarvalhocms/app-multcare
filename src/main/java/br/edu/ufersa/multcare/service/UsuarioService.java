package br.edu.ufersa.multcare.service;

import br.edu.ufersa.multcare.persistence.entities.Usuario;
import br.edu.ufersa.multcare.shared.dto.UsuarioDTO;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {

    String cadastrarUsuario(UsuarioDTO usuarioDTO);

    Usuario obterUsuarioPorLogin(String login);

    Usuario obterUsuarioPorNome(String nome);
}
