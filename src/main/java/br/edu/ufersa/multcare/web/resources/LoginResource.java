package br.edu.ufersa.multcare.web.resources;

import br.edu.ufersa.multcare.auth.AuthenticationException;
import br.edu.ufersa.multcare.service.LoginService;
import br.edu.ufersa.multcare.shared.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping(value="/api")
public class LoginResource {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<String> realizarLogin(@Valid @RequestBody LoginDTO login) throws AuthenticationException {

        String jwt = loginService.realizarLogin(login);
        return ResponseEntity.ok(jwt);
    }


}