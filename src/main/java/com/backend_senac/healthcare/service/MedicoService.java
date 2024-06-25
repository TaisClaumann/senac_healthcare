package com.backend_senac.healthcare.service;

import com.backend_senac.healthcare.domain.Medico;
import com.backend_senac.healthcare.domain.dto.MedicoDto;
import com.backend_senac.healthcare.exceptions.RegistroNaoEncontradoException;
import com.backend_senac.healthcare.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> listar() {
        return medicoRepository.findAll();
    }

    public Medico buscarPorId(Long id) {
        return medicoRepository.findById(id).orElseThrow(() -> new RegistroNaoEncontradoException("Medico", id));
    }

    public Medico salvar(MedicoDto medicoDto) {
        Medico medico = new Medico(medicoDto);
        return medicoRepository.save(medico);
    }

    public Medico atualizar(Long id, MedicoDto medicoDto) {
        Medico medico = medicoRepository.findById(id).orElseThrow();
        medicoDto.setId(medico.getId());
        return medicoRepository.save(new Medico(medicoDto));
    }

    public void excluir(Long id) {
        medicoRepository.deleteById(id);
    }

    public boolean existe(Long id) {
        return medicoRepository.existsById(id);
    }
}
