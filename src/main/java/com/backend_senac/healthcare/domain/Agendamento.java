package com.backend_senac.healthcare.domain;

import com.backend_senac.healthcare.domain.dto.AgendamentoDto;
import com.backend_senac.healthcare.domain.dto.MedicoDto;
import com.backend_senac.healthcare.enums.StatusAgendamento;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
public class Agendamento extends Base {

    private OffsetDateTime data;

    @Enumerated(EnumType.STRING)
    private StatusAgendamento status;

    @ManyToOne
    private Paciente paciente;
    @ManyToOne
    private Medico medico;

    public Agendamento(AgendamentoDto agendamentoDto) {
        super();
        this.data = agendamentoDto.getData();
        this.status = agendamentoDto.getStatus();
        this.paciente = new Paciente(agendamentoDto.getPaciente());
    }
}
