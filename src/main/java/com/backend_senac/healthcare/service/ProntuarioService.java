package com.backend_senac.healthcare.service;

import com.backend_senac.healthcare.domain.Prontuario;
import com.backend_senac.healthcare.exceptions.RegistroNaoEncontradoException;
import com.backend_senac.healthcare.repository.ProntuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProntuarioService {
    
    @Autowired
    private ProntuarioRepository prontuarioRepository;
    @Autowired
    private MedicoService medicoService;
    @Autowired
    private PacienteService pacienteService;

    public Prontuario salvar(Prontuario prontuario) {
        medicoService.buscarPorId(prontuario.getMedico().getId());
        pacienteService.buscarPorId(prontuario.getPaciente().getId());
        return prontuarioRepository.save(prontuario);
    }

    public Prontuario alterar(Long id, Prontuario prontuario) {
        buscarPorId(id);
        prontuario.setId(id);
        return salvar(prontuario);
    }

    public Prontuario buscarPorId(Long id) {
        return prontuarioRepository.findById(id).orElseThrow(() ->
                new RegistroNaoEncontradoException("Prontuario com id " + id + " não encontrado"));
    }

    public void excluir(Long id) {
        buscarPorId(id);
        prontuarioRepository.deleteById(id);
    }

    public List<Prontuario> listarTodos() {
        return prontuarioRepository.findAll();
    }
}
