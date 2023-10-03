package med.voll.api.domain.consulta;


import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository repository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public void agendar(DadosAgendamentoConsulta dados) {
        if(!pacienteRepository.existsById(dados.idPaciente())) {
            throw new ValidacaoException("O Id do paciente informado não pode ser encontrado");
        }
        if(dados.idMedico() != null && medicoRepository.existsById(dados.idMedico())) {
            throw new ValidacaoException("O Id do médico informado não pode ser encontrado");
        }

        var paciente = pacienteRepository.findById(dados.idPaciente()).get();
        var medico = atribuirMedico(dados);

        var consulta = new Consulta(null, medico, paciente, dados.data());
        repository.save(consulta);
    }

    private Medico atribuirMedico(DadosAgendamentoConsulta dados) {
        return null;
    }
}
