package com.backend_senac.healthcare.service;

import com.backend_senac.healthcare.domain.Agendamento;
import com.backend_senac.healthcare.domain.Medico;
import com.backend_senac.healthcare.exceptions.RegistroJaCadastradoException;
import com.backend_senac.healthcare.exceptions.RegistroNaoEncontradoException;
import com.backend_senac.healthcare.repository.AgendamentoRepository;
import com.backend_senac.healthcare.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
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

        if (hasDataEHoraDisponivel(agendamento.getData())) {
            OffsetDateTime data = agendamento.getData().truncatedTo(ChronoUnit.MINUTES);
            agendamento.setData(data);
            return agendamentoRepository.save(agendamento);
        }
        throw new RegistroJaCadastradoException("Agendamento para " + DataUtils.offsetDateTimeToString(agendamento.getData()) + " não disponível");
    }

    private boolean hasDataEHoraDisponivel(OffsetDateTime data) {
        OffsetDateTime dataSemSegundos = data.truncatedTo(ChronoUnit.MINUTES);
        return !agendamentoRepository.existsByData(dataSemSegundos);
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
