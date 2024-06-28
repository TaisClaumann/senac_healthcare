package com.backend_senac.healthcare.service;

import com.backend_senac.healthcare.domain.Medico;
import com.backend_senac.healthcare.domain.Paciente;
import com.backend_senac.healthcare.domain.Prontuario;
import com.backend_senac.healthcare.domain.dto.MedicoDto;
import com.backend_senac.healthcare.domain.dto.ProntuarioDto;
import com.backend_senac.healthcare.exceptions.RegistroNaoEncontradoException;
import com.backend_senac.healthcare.repository.ProntuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProntuarioService {
    
    @Autowired
    private ProntuarioRepository prontuarioRepository;
    @Autowired
    private MedicoService medicoService;
    @Autowired
    private PacienteService pacienteService;

    public Prontuario salvar(Prontuario prontuario) {
        if (Objects.nonNull(prontuario.getMedico())) medicoService.buscarPorId(prontuario.getMedico().getId());
        if (Objects.nonNull(prontuario.getPaciente())) pacienteService.buscarPorId(prontuario.getPaciente().getId());
        return prontuarioRepository.save(prontuario);
    }

    public Prontuario alterar(Long id, Prontuario prontuario) {
        buscarPorId(id);
        prontuario.setId(id);
        return salvar(prontuario);
    }

    public Prontuario buscarPorId(Long id) {
        return prontuarioRepository.findById(id).orElseThrow(() ->
                new RegistroNaoEncontradoException("Prontuario", id));
    }

    public void excluir(Long id) {
        buscarPorId(id);
        prontuarioRepository.deleteById(id);
    }

    public List<Prontuario> listarTodos() {
        return prontuarioRepository.findAll();
    }

    public List<ProntuarioDto> listarPorPaciente(Long pacienteId) {
        Paciente paciente = pacienteService.buscarPorId(pacienteId);
        return prontuarioRepository.findByPaciente(paciente).stream().map(ProntuarioDto::new).toList();
    }

    public List<ProntuarioDto> listarPorMedico(Long medicoId) {
        Medico medico = medicoService.buscarPorId(medicoId);
        return prontuarioRepository.findByMedico(medico).stream().map(ProntuarioDto::new).toList();
    }

    public List<ProntuarioDto> listarPorPacienteEMedico(Long pacienteId, Long medicoId) {
        Paciente paciente = pacienteService.buscarPorId(pacienteId);
        Medico medico = medicoService.buscarPorId(medicoId);
        return prontuarioRepository.findByMedicoAndPaciente(medico, paciente).stream().map(ProntuarioDto::new).toList();
    }
}
