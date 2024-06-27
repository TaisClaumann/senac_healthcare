package com.backend_senac.healthcare.controller;

import com.backend_senac.healthcare.domain.Faturamento;
import com.backend_senac.healthcare.domain.dto.FaturamentoDto;
import com.backend_senac.healthcare.service.FaturamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faturamentos")
public class FaturamentoController {

    @Autowired
    private FaturamentoService faturamentoService;

    @PostMapping
    public FaturamentoDto salvar(@RequestBody Faturamento faturamento) {
        return new FaturamentoDto(faturamentoService.salvar(faturamento));
    }

    @PutMapping("/{id}")
    public FaturamentoDto alterar(@RequestBody Faturamento faturamento, @PathVariable("id") Long id) {
        return new FaturamentoDto(faturamentoService.alterar(id, faturamento));
    }

    @GetMapping("/{id}")
    public FaturamentoDto buscarPorId(@PathVariable("id") Long id) {
        return new FaturamentoDto(faturamentoService.buscarPorId(id));
    }

    @GetMapping
    public List<FaturamentoDto> listarTodos() {
        return faturamentoService.listarTodos().stream().map(FaturamentoDto::new).toList();
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long id) {
        faturamentoService.excluir(id);
    }

    @GetMapping("/{pacienteId}/paciente")
    public FaturamentoDto buscarPorPaciente(@PathVariable("pacienteId") Long pacienteId) {
        return new FaturamentoDto(faturamentoService.buscarPorPaciente(pacienteId));
    }
}
