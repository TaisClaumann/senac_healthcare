package com.backend_senac.healthcare.repository;

import com.backend_senac.healthcare.domain.Medico;
import com.backend_senac.healthcare.domain.Paciente;
import com.backend_senac.healthcare.domain.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {

    List<Prontuario> findByPaciente(Paciente paciente);
    List<Prontuario> findByMedico(Medico medico);
    List<Prontuario> findByMedicoAndPaciente(Medico medico, Paciente paciente);
}
