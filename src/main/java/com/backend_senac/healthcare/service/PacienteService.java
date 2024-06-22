package com.backend_senac.healthcare.service;

import com.backend_senac.healthcare.domain.Paciente;
import com.backend_senac.healthcare.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

//    @PostMapping
//    public Paciente salvar(@RequestBody Paciente paciente) {
//
//    }
}
