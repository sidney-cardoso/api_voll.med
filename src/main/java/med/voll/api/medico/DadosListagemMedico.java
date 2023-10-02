package med.voll.api.medico;

import jakarta.validation.constraints.NotNull;

public record DadosListagemMedico(
        @NotNull
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {
    public DadosListagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}
