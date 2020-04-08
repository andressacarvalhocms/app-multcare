package br.edu.ufersa.multcare.shared.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter @ToString
public class LoginDTO {

    @NotNull(message = "O campo idade é obrigatório") @NotEmpty
    private String usuario;

    @NotNull(message = "O campo nome é obrigatório") @NotEmpty
    private String senha;

}
