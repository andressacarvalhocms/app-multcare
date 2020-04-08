package br.edu.ufersa.multcare.persistence.repositories;

import br.edu.ufersa.multcare.persistence.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findUsuarioByLoginEquals(String login);

	Usuario findUsuarioByNomeEqualsAndLoginEquals(String nome, String login);

	Usuario findUsuarioByNomeEquals(String nome);
	
}