package com.backend_senac.healthcare.controller;

import com.backend_senac.healthcare.domain.Agendamento;
import com.backend_senac.healthcare.domain.Agendamento;
import com.backend_senac.healthcare.domain.dto.AgendamentoDto;
import com.backend_senac.healthcare.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    public AgendamentoDto salvar(@RequestBody Agendamento agendamento) {
        return new AgendamentoDto(agendamentoService.salvar(agendamento));
    }

    @PutMapping("/{id}")
    public AgendamentoDto alterar(@RequestBody Agendamento agendamento, @PathVariable("id") Long id) {
        return new AgendamentoDto(agendamentoService.alterar(id, agendamento));
    }

    @GetMapping("/{id}")
    public AgendamentoDto buscarPorId(@PathVariable("id") Long id) {
        return new AgendamentoDto(agendamentoService.buscarPorId(id));
    }

    @GetMapping
    public List<AgendamentoDto> listarTodos() {
        return agendamentoService.listarTodos().stream().map(AgendamentoDto::new).toList();
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long id) {
        agendamentoService.excluir(id);
    }
}
