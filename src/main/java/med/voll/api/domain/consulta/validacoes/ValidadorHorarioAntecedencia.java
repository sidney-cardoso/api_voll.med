package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

import java.time.Duration;
import java.time.LocalDateTime;

public class ValidadorHorarioAntecedencia {
    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var dataAtual = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(dataAtual, dataConsulta).toMinutes();

        if(diferencaEmMinutos < 30) {
            throw new ValidacaoException("Consulta deve ser agendada com no mínimo 30 minutos de antecedência!");
        }
    }
}