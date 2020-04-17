package br.edu.ufersa.multcare.shared.exception;

import javassist.NotFoundException;

public class TipoExameNotFound extends NotFoundException {

    public TipoExameNotFound() {
        super("Tipo de Exame não cadastrado com essa descrição.");
    }
}
