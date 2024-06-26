package com.backend_senac.healthcare.repository;

import com.backend_senac.healthcare.domain.Agendamento;
import com.backend_senac.healthcare.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    boolean existsByData(OffsetDateTime data);
}
