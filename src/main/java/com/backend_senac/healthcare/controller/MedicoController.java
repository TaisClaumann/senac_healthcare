package com.backend_senac.healthcare.controller;

import com.backend_senac.healthcare.domain.Medico;
import com.backend_senac.healthcare.domain.dto.MedicoDto;
import com.backend_senac.healthcare.exceptions.RegistroNaoEncontradoException;
import com.backend_senac.healthcare.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public List<MedicoDto> listar() {
        return medicoService.listar().stream()
                .map(MedicoDto::new)
                .toList();
    }

    @GetMapping("/{id}")
    public MedicoDto buscarPorId(@PathVariable("id") Long id) {
        return new MedicoDto(medicoService.buscarPorId(id));
    }

    @PostMapping
    public MedicoDto salvar(@RequestBody MedicoDto medicoDto) {
        return new MedicoDto(medicoService.salvar(medicoDto));
    }

    @PutMapping("/{id}")
    public MedicoDto atualizar(@PathVariable("id") Long id, @RequestBody MedicoDto medicoDto) {
        return new MedicoDto(medicoService.atualizar(id, medicoDto));
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long id) {
        if (!medicoService.existe(id)) {
            throw new RegistroNaoEncontradoException("Medico", id);
        }
        medicoService.excluir(id);
    }
}
