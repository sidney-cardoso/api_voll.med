package med.voll.api.domain.medico;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosMedico(
        @NotBlank(message = "Campo nome deve ser preenchido!")
        String nome,

        @NotBlank(message = "Campo E-mail deve ser preenchido!")
        @Email
        String email,

        @NotBlank(message = "Campo crm deve ser preenchido!")
        @Pattern(regexp = "\\d{4,10}")
        String crm,

        @NotBlank(message = "Campo telefone deve ser preenchido!")
        String telefone,


        @NotNull(message = "Uma especialidade deve ser adicionada!")
        Especialidade especialidade,

        med.voll.api.domain.endereco.DadosEndereco endereco) {
}
