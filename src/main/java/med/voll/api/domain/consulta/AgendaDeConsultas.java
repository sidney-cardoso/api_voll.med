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

        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var medico = atribuirMedico(dados);

        var consulta = new Consulta(null, medico, paciente, dados.data(), null);
        repository.save(consulta);
    }

    public void cancelar(DadosCancelamentoConsulta dados) {
        if(!repository.existsById(dados.idConsulta())) {
            throw new ValidacaoException("Consulta não encontrada!");
        }

        var consulta = repository.getReferenceById(dados.idConsulta());
        consulta.cancelar(dados.motivo());
    }

    private Medico atribuirMedico(DadosAgendamentoConsulta dados) {
        if(dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }
        if(dados.especialidade() == null) {
            throw new ValidacaoException("Especialidade é obrigatória caso não tenha escolhido um médico");
        }


        return medicoRepository.escolherMedicoAleatorioLivre(dados.especialidade(), dados.data());
    }
}
