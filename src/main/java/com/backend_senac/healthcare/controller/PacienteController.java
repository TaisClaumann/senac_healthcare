package com.backend_senac.healthcare.controller;

import com.backend_senac.healthcare.domain.Paciente;
import com.backend_senac.healthcare.domain.dto.PacienteDto;
import com.backend_senac.healthcare.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public PacienteDto salvar(@RequestBody Paciente paciente) {
        return new PacienteDto(pacienteService.salvar(paciente));
    }

    @PutMapping("/{id}")
    public PacienteDto alterar(@RequestBody Paciente paciente, @PathVariable("id") Long id) {
        return new PacienteDto(pacienteService.alterar(id, paciente));
    }

    @GetMapping("/{id}")
    public PacienteDto buscarPorId(@PathVariable("id") Long id) {
        return new PacienteDto(pacienteService.buscarPorId(id));
    }

    @GetMapping
    public List<PacienteDto> listarTodos() {
        return pacienteService.listarTodos().stream().map(PacienteDto::new).toList();
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long id) {
        pacienteService.excluir(id);
    }
}
