package med.voll.api.medico;

import med.voll.api.endereco.Endereco;

public record DadosMedico(
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        Endereco endereco) {
}
