package med.voll.api.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank
        String logradouro,

        @NotBlank
        String bairro,

        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,

        @NotBlank
        String numero,

        @NotBlank
        String cidade,
        String uf,
        String complemento) {

    public DadosEndereco(DadosEndereco dados) {
        this(
                dados.logradouro,
                dados.bairro(),
                dados.cep,
                dados.numero(),
                dados.cidade(),
                dados.uf(),
                dados.complemento()
        );
    }
}
