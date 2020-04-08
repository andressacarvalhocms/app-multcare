package br.edu.ufersa.multcare.service.impl;

import br.edu.ufersa.multcare.auth.UserJWTController;
import br.edu.ufersa.multcare.service.LoginService;

import br.edu.ufersa.multcare.auth.AuthenticationException;
import br.edu.ufersa.multcare.shared.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LonginServiceImpl implements LoginService {

    @Autowired
    private UserJWTController userJWTController;

    @Override
    public String realizarLogin(LoginDTO login) throws AuthenticationException {
        return userJWTController.authenticate(login.getUsuario(), login.getSenha());
    }
}
