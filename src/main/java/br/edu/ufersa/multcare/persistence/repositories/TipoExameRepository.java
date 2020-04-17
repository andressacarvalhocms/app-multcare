package br.edu.ufersa.multcare.persistence.repositories;

import br.edu.ufersa.multcare.persistence.entities.TipoExame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoExameRepository extends JpaRepository<TipoExame, Long>{

    Boolean existsByDescricaoEquals(String descricao);

    Optional<TipoExame> findTipoExameByDescricaoEquals(String descricao);
}