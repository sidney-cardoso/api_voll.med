package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComConsultasNoMesmoHorario implements ValidadorAgendamentoDeConsultas{

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var medicoPossuiConsultasNoMesmoHorario = repository.existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(dados.idMedico(), dados.data());
        if(medicoPossuiConsultasNoMesmoHorario) {
            throw new ValidacaoException("Médico já possui uma consulta agendada nesse horário!");
        }
    }
}
