package br.edu.ufersa.multcare.auth;

import br.edu.ufersa.multcare.persistence.entities.Usuario;
import br.edu.ufersa.multcare.service.UsuarioService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.util.Date;

@Component
public class UserJWTController {

	private UsuarioService usuarioService;

	public String secret = "secret";

	public UserJWTController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public String authenticate(String username, String password) throws AuthenticationException
	{
		try {
			Usuario user = usuarioService.obterUsuarioPorLogin(username);
			if(user == null) {
				throw new AuthenticationException("Usuário não encontrado");
			}
			
			String hashPassword = passwordHash(password);

			if(!hashPassword.equals(user.getSenha())) {
				throw new AuthenticationException("Senha incorreta");
			}

			return JWTTokenGen(user.getLogin());
		} catch (AuthenticationException e) {
			throw e;
		} catch (Exception e) {
			throw new AuthenticationException("Problema na autenticação, tente novamente.");
		}
	}
	
	public Usuario getLoggedUserByToken(String token) throws AuthenticationException {
		try {
			String username = JWTTokenVerify(token);
			
			Usuario user = usuarioService.obterUsuarioPorNome(username);
			if(user == null)
				throw new AuthenticationException("Usuário não encontrado");
			
			return user;
		} catch (Exception e) {
			throw new AuthenticationException(e.getMessage());
		}
	}
	
	public String JWTTokenGen(String uuid) {
		try {
			
			Algorithm algorithmHS = Algorithm.HMAC256(secret);
		    String token = JWT.create()
		        .withIssuer(uuid).withExpiresAt(new Date(System.currentTimeMillis() + (60 * 60 * 24)))
		        .sign(algorithmHS);
		    return token;
		} catch (Exception e) {
			return null;
		}
	}
	
	public String JWTTokenVerify(String token) {
		try {
		    Algorithm algorithm = Algorithm.HMAC256(secret);
		    JWTVerifier verifier = JWT.require(algorithm)
		        .withIssuer("auth0")
		        .build(); //Reusable verifier instance
		    DecodedJWT jwt = verifier.verify(token);
		    
		    String issuer = jwt.getIssuer();
		    return issuer;
		} catch (Exception exception){
			return null;
		}
	}

	public static String passwordHash(String password)
	{
		try{
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hash = digest.digest(password.getBytes("UTF-8"));
	        StringBuffer hexString = new StringBuffer();

	        for (int i = 0; i < hash.length; i++) {
	            String hex = Integer.toHexString(0xff & hash[i]);
	            if(hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
	        }

	        return hexString.toString();
	    } catch(Exception ex){
	    	ex.printStackTrace();
	    }
		
		return null;
	}
}
