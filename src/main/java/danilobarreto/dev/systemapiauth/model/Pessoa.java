package danilobarreto.dev.systemapiauth.model;

import danilobarreto.dev.systemapiauth.model.audit.UserDateAudit;
import danilobarreto.dev.systemapiauth.model.enums.Cargo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pessoas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pessoa extends UserDateAudit {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Cargo funcao;

    private String excluido = "N";


    public Pessoa(Object o, @NotBlank String nome, @NotBlank String telefone, @NotNull Cargo funcao) {
        super();
    }
}
