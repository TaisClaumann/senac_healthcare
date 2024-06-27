package com.backend_senac.healthcare.service;

import com.backend_senac.healthcare.domain.Faturamento;
import com.backend_senac.healthcare.domain.Paciente;
import com.backend_senac.healthcare.exceptions.RegistroNaoEncontradoException;
import com.backend_senac.healthcare.repository.FaturamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class FaturamentoService {

    @Autowired
    private FaturamentoRepository faturamentoRepository;
    @Autowired
    private PacienteService pacienteService;

    public Faturamento salvar(Faturamento faturamento) {
        pacienteService.buscarPorId(faturamento.getPaciente().getId());
        return faturamentoRepository.save(faturamento);
    }

    public Faturamento atualizarTotalFaturamento(Faturamento faturamento, double valorItemFaturamento) {
        double totalFaturamento = Objects.isNull(faturamento.getValorTotal()) ? valorItemFaturamento : faturamento.getValorTotal() + valorItemFaturamento;
        faturamento.setValorTotal(totalFaturamento);
        return salvar(faturamento);
    }

    public Faturamento alterar(Long id, Faturamento faturamento) {
        buscarPorId(id);
        faturamento.setId(id);
        return salvar(faturamento);
    }

    public Faturamento buscarPorId(Long id) {
        return faturamentoRepository.findById(id).orElseThrow(() ->
                new RegistroNaoEncontradoException("Faturamento com id " + id + " não encontrado"));
    }

    public void excluir(Long id) {
        buscarPorId(id);
        faturamentoRepository.deleteById(id);
    }

    public List<Faturamento> listarTodos() {
        return faturamentoRepository.findAll();
    }

    public Faturamento buscarPorPaciente(Long pacienteId) {
        Paciente paciente = pacienteService.buscarPorId(pacienteId);
        return faturamentoRepository.findByPaciente(paciente).orElseThrow(() ->
                new RegistroNaoEncontradoException("Não existe faturamento para o paciente " + paciente.getNome()));
    }
}
