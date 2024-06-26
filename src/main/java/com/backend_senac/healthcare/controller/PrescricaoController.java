package com.backend_senac.healthcare.controller;

import com.backend_senac.healthcare.domain.Prescricao;
import com.backend_senac.healthcare.domain.dto.PrescricaoDto;
import com.backend_senac.healthcare.service.PrescricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescricoes")
public class PrescricaoController {

    @Autowired
    private PrescricaoService prescricaoService;

    @PostMapping
    public PrescricaoDto salvar(@RequestBody Prescricao Prescricao) {
        return new PrescricaoDto(prescricaoService.salvar(Prescricao));
    }

    @PutMapping("/{id}")
    public PrescricaoDto alterar(@RequestBody Prescricao Prescricao, @PathVariable("id") Long id) {
        return new PrescricaoDto(prescricaoService.alterar(id, Prescricao));
    }

    @GetMapping("/{id}")
    public PrescricaoDto buscarPorId(@PathVariable("id") Long id) {
        return new PrescricaoDto(prescricaoService.buscarPorId(id));
    }

    @GetMapping
    public List<PrescricaoDto> listarTodos() {
        return prescricaoService.listarTodos().stream().map(PrescricaoDto::new).toList();
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long id) {
        prescricaoService.excluir(id);
    }
}
