package br.edu.ufersa.multcare.shared.builder;

import br.edu.ufersa.multcare.persistence.entities.TipoExame;

public class TipoExameBuilder {

    private TipoExame tipoExame;

    public TipoExameBuilder() {
        this.tipoExame = new TipoExame();
    }

    public static TipoExameBuilder of(){
        return new TipoExameBuilder();
    }

    public TipoExameBuilder comDescricao(String descricao) {
        this.tipoExame.setDescricao(descricao);
        return this;
    }

    public TipoExameBuilder comUnidadeMedida(String unidadeMedida) {
        this.tipoExame.setUnidadeMedida(unidadeMedida);
        return this;
    }

    public TipoExame build() {
        return this.tipoExame;
    }
}
