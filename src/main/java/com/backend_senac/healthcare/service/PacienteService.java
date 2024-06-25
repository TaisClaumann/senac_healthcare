package com.backend_senac.healthcare.service;

import com.backend_senac.healthcare.domain.Paciente;
import com.backend_senac.healthcare.domain.dto.PacienteDto;
import com.backend_senac.healthcare.exceptions.RegistroNaoEncontradoException;
import com.backend_senac.healthcare.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente salvar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente alterar(Long id, Paciente paciente) {
        buscarPorId(id);
        paciente.setId(id);
        return salvar(paciente);
    }

    public Paciente buscarPorId(Long id) {
        return pacienteRepository.findById(id).orElseThrow(() ->
                new RegistroNaoEncontradoException("Paciente com id " + id + " não encontrado"));
    }

    public void excluir(Long id) {
        buscarPorId(id);
        pacienteRepository.deleteById(id);
    }

    public List<Paciente> buscarTodos() {
        return pacienteRepository.findAll();
    }
}
