package com.backend_senac.healthcare.domain.dto;

import com.backend_senac.healthcare.domain.Agendamento;
import com.backend_senac.healthcare.domain.Medico;
import com.backend_senac.healthcare.domain.Paciente;
import com.backend_senac.healthcare.enums.StatusAgendamento;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class AgendamentoDto {

    private Long id;
    private OffsetDateTime data;

    @Enumerated(EnumType.STRING)
    private StatusAgendamento status;

    private PacienteDto paciente;
    private MedicoDto medico;
    private OffsetDateTime createdDate;
    private OffsetDateTime modifiedDate;

    public AgendamentoDto(Agendamento agendamento) {
        this.id = agendamento.getId();
        this.data = agendamento.getData();
        this.status = agendamento.getStatus();
        this.paciente = new PacienteDto(agendamento.getPaciente());
        this.medico = new MedicoDto(agendamento.getMedico());
        this.createdDate = agendamento.getCreatedDate();
        this.modifiedDate = agendamento.getModifiedDate();
    }
}
