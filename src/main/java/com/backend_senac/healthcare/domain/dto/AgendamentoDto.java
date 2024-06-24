package com.backend_senac.healthcare.domain.dto;

import com.backend_senac.healthcare.domain.Agendamento;
import com.backend_senac.healthcare.domain.Medico;
import com.backend_senac.healthcare.domain.Paciente;
import com.backend_senac.healthcare.enums.StatusAgendamento;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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

    private Paciente paciente;

    private Medico medico;

    private OffsetDateTime createdDate;

    private OffsetDateTime modifiedDate;

    public AgendamentoDto(Agendamento agendamento) {
        this.id = medico.getId();
        this.data = agendamento.getData();
        this.status = agendamento.getStatus();
        this.paciente = agendamento.getPaciente();
        this.medico = agendamento.getMedico();
        this.createdDate = agendamento.getCreatedDate();
        this.modifiedDate = agendamento.getModifiedDate();
    }
}
