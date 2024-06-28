package com.backend_senac.healthcare.controller;

import com.backend_senac.healthcare.domain.Prontuario;
import com.backend_senac.healthcare.domain.dto.ProntuarioDto;
import com.backend_senac.healthcare.service.ProntuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prontuarios")
public class ProntuarioController {

    @Autowired
    private ProntuarioService prontuarioService;

    @PostMapping
    public ProntuarioDto salvar(@RequestBody Prontuario prontuario) {
        return new ProntuarioDto(prontuarioService.salvar(prontuario));
    }

    @PutMapping("/{id}")
    public ProntuarioDto alterar(@RequestBody Prontuario prontuario, @PathVariable("id") Long id) {
        return new ProntuarioDto(prontuarioService.alterar(id, prontuario));
    }

    @GetMapping("/{id}")
    public ProntuarioDto buscarPorId(@PathVariable("id") Long id) {
        return new ProntuarioDto(prontuarioService.buscarPorId(id));
    }

    @GetMapping
    public List<ProntuarioDto> listarTodos() {
        return prontuarioService.listarTodos().stream().map(ProntuarioDto::new).toList();
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long id) {
        prontuarioService.excluir(id);
    }

    @GetMapping("{pacienteId}/paciente")
    public List<ProntuarioDto> listarPorPaciente(@PathVariable("pacienteId") Long pacienteId) {
        return prontuarioService.listarPorPaciente(pacienteId);
    }

    @GetMapping("{medicoId}/medico")
    public List<ProntuarioDto> listarPorMedico(@PathVariable("medicoId") Long medicoId) {
        return prontuarioService.listarPorPaciente(medicoId);
    }

    @GetMapping("/paciente/{pacienteId}/medico/{medicoId}")
    public List<ProntuarioDto> listarPorMedicoEPaciente(@PathVariable("pacienteId") Long pacienteId,
                                                        @PathVariable("medicoId") Long medicoId) {
        return prontuarioService.listarPorPacienteEMedico(pacienteId, medicoId);
    }
}
