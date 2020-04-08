package br.edu.ufersa.multcare.service;

import br.edu.ufersa.multcare.auth.AuthenticationException;
import br.edu.ufersa.multcare.shared.dto.LoginDTO;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    String realizarLogin(LoginDTO login) throws AuthenticationException;
}
