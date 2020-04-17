package br.edu.ufersa.multcare.persistence.initializer;

import br.edu.ufersa.multcare.persistence.entities.TipoExame;
import br.edu.ufersa.multcare.persistence.repositories.TipoExameRepository;
import br.edu.ufersa.multcare.shared.builder.TipoExameBuilder;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class TipoExameInitializer {

    @Bean
    public ApplicationRunner salvarSeNaoExistir(TipoExameRepository tipoExameRepository) {

        List<TipoExame> tipoExames = Arrays.asList(
                TipoExameBuilder.of().comDescricao("Pressão Arterial").comUnidadeMedida("mmHg").build(),
                TipoExameBuilder.of().comDescricao("Creatinina").comUnidadeMedida("mg/dL").build(),
                TipoExameBuilder.of().comDescricao("Uréia").comUnidadeMedida("mg/dL").build(),
                TipoExameBuilder.of().comDescricao("Albuminúria").comUnidadeMedida("mg/dL").build(),
                TipoExameBuilder.of().comDescricao("Potássio").comUnidadeMedida("mEq/L").build(),
                TipoExameBuilder.of().comDescricao("TFG").comUnidadeMedida("mL/min/1,73 m²").build(),
                TipoExameBuilder.of().comDescricao("Microalbuminúria").comUnidadeMedida("mmHg").build(),
                TipoExameBuilder.of().comDescricao("Glicemia de jejum").comUnidadeMedida("mg/dL").build(),
                TipoExameBuilder.of().comDescricao("Glicemia pré-prandial").comUnidadeMedida("mg/dL").build(),
                TipoExameBuilder.of().comDescricao("Glicemia pós-prandial").comUnidadeMedida("mg/dL").build()
        );

        List<TipoExame> naoSalvos= tipoExames.stream()
                .filter(tipo -> !tipoExameRepository.existsByDescricaoEquals(tipo.getDescricao()))
                .collect(Collectors.toList());

        return args -> tipoExameRepository.saveAll(naoSalvos);
    }
}
