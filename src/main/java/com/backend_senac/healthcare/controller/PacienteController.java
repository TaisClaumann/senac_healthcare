package com.backend_senac.healthcare.controller;

import com.backend_senac.healthcare.domain.Paciente;
import com.backend_senac.healthcare.domain.dto.PacienteDto;
import com.backend_senac.healthcare.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public PacienteDto salvar(@RequestBody Paciente paciente) {
        return pacienteService.salvar(paciente);
    }
}
