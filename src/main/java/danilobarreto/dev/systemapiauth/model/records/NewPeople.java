package danilobarreto.dev.systemapiauth.model.records;

import danilobarreto.dev.systemapiauth.model.enums.Cargo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NewPeople (
        @NotBlank
        String nome,
        @NotBlank
        String username,
        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        String senha,
        @NotNull
        Cargo funcao
){
}
