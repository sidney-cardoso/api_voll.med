package med.voll.api.medico;

import med.voll.api.endereco.DadosEndereco;
import med.voll.api.endereco.Endereco;

public record DadosAtualizacaoMedico(
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
