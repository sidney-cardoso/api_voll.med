package med.voll.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByStatusTrue(Pageable paginacao);

    @Query("""
            SELECT m from Medico m
            WHERE m.status = true
            AND m.especialidade = :especialidade
            AND m.id NOT IN(
                SELECT c.medico.id FROM Consulta c
                WHERE c.data = :data
            )
            ORDER BY rand()
            LIMIT 1
            """)
    Medico escolherMedicoAleatorioLivre(Especialidade especialidade, LocalDateTime data);

    @Query("""
           SELECT m.status FROM Medico m
           WHERE m.id = :id
           """)
    Boolean findAtivoById(Long idMedico);
}
