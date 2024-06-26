package com.backend_senac.healthcare.service;

import com.backend_senac.healthcare.domain.Medicamento;
import com.backend_senac.healthcare.exceptions.RegistroNaoEncontradoException;
import com.backend_senac.healthcare.repository.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentoService {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    public Medicamento salvar(Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    public Medicamento buscarPorId(Long id) {
        return medicamentoRepository.findById(id).orElseThrow(() ->
                new RegistroNaoEncontradoException("Medicamento com id " + id + " não encontrado"));
    }

    public Medicamento alterar(Long id, Medicamento medicamento) {
        buscarPorId(id);
        medicamento.setId(id);
        return salvar(medicamento);
    }

    public List<Medicamento> listarTodos() {
        return medicamentoRepository.findAll();
    }

    public void excluir(Long id) {
        buscarPorId(id);
        medicamentoRepository.deleteById(id);
    }
}
