package com.backend_senac.healthcare.controller;

import com.backend_senac.healthcare.domain.Medicamento;
import com.backend_senac.healthcare.domain.dto.MedicamentoDto;
import com.backend_senac.healthcare.service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    @Autowired
    private MedicamentoService medicamentoService;

    @PostMapping
    public MedicamentoDto salvar(@RequestBody Medicamento Medicamento) {
        return new MedicamentoDto(medicamentoService.salvar(Medicamento));
    }

    @PutMapping("/{id}")
    public MedicamentoDto alterar(@RequestBody Medicamento Medicamento, @PathVariable("id") Long id) {
        return new MedicamentoDto(medicamentoService.alterar(id, Medicamento));
    }

    @GetMapping("/{id}")
    public MedicamentoDto buscarPorId(@PathVariable("id") Long id) {
        return new MedicamentoDto(medicamentoService.buscarPorId(id));
    }

    @GetMapping
    public List<MedicamentoDto> listarTodos() {
        return medicamentoService.listarTodos().stream().map(MedicamentoDto::new).toList();
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long id) {
        medicamentoService.excluir(id);
    }
}
