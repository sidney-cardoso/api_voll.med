package med.voll.api.domain.consulta;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsulta(
        @NotNull
        @JsonAlias("id_consulta")
        Long idConsulta,

        @NotNull
        MotivoCancelamento motivo
) {
}
