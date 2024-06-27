package com.backend_senac.healthcare.repository;

import com.backend_senac.healthcare.domain.Faturamento;
import com.backend_senac.healthcare.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FaturamentoRepository extends JpaRepository<Faturamento, Long> {

    Optional<Faturamento> findByPaciente(Paciente paciente);

}
