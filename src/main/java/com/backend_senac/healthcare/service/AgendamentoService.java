package com.backend_senac.healthcare.service;

import com.backend_senac.healthcare.domain.Agendamento;
import com.backend_senac.healthcare.domain.Medico;
import com.backend_senac.healthcare.exceptions.RegistroNaoEncontradoException;
import com.backend_senac.healthcare.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private MedicoService medicoService;

    public Agendamento salvar(Agendamento agendamento) {
        pacienteService.buscarPorId(agendamento.getPaciente().getId());
        medicoService.buscarPorId(agendamento.getMedico().getId());
        return agendamentoRepository.save(agendamento);
    }

    public Agendamento alterar(Long id, Agendamento agendamento) {
        buscarPorId(id);
        agendamento.setId(id);
        return salvar(agendamento);
    }

    public Agendamento buscarPorId(Long id) {
        return agendamentoRepository.findById(id).orElseThrow(() ->
                new RegistroNaoEncontradoException("Agendamento com id " + id + " não encontrado"));
    }

    public void excluir(Long id) {
        buscarPorId(id);
        agendamentoRepository.deleteById(id);
    }

    public List<Agendamento> listarTodos() {
        return agendamentoRepository.findAll();
    }
}
