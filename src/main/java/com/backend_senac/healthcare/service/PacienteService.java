package com.backend_senac.healthcare.service;

import com.backend_senac.healthcare.domain.Paciente;
import com.backend_senac.healthcare.domain.dto.PacienteDto;
import com.backend_senac.healthcare.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public PacienteDto salvar(Paciente paciente) {
        return new PacienteDto(pacienteRepository.save(paciente));
    }
}
