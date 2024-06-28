package com.backend_senac.healthcare.service;

import com.backend_senac.healthcare.domain.Prescricao;
import com.backend_senac.healthcare.exceptions.RegistroNaoEncontradoException;
import com.backend_senac.healthcare.repository.PrescricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescricaoService {
    
    @Autowired
    private PrescricaoRepository prescricaoRepository;
    @Autowired
    private MedicoService medicoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private MedicamentoService medicamentoService;

    public Prescricao salvar(Prescricao prescricao) {
        medicoService.buscarPorId(prescricao.getMedico().getId());
        pacienteService.buscarPorId(prescricao.getPaciente().getId());

        prescricao.getMedicamentos().stream().map(m -> medicamentoService.buscarPorId(m.getId()));
        return prescricaoRepository.save(prescricao);
    }

    public Prescricao alterar(Long id, Prescricao Prescricao) {
        buscarPorId(id);
        Prescricao.setId(id);
        return salvar(Prescricao);
    }

    public Prescricao buscarPorId(Long id) {
        return prescricaoRepository.findById(id).orElseThrow(() ->
                new RegistroNaoEncontradoException("Prescricao", id));
    }

    public void excluir(Long id) {
        buscarPorId(id);
        prescricaoRepository.deleteById(id);
    }

    public List<Prescricao> listarTodos() {
        return prescricaoRepository.findAll();
    }
}
