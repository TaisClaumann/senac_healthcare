package com.backend_senac.healthcare.domain;

import com.backend_senac.healthcare.domain.dto.ProntuarioDto;
import com.backend_senac.healthcare.enums.StatusAgendamento;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
public class Prontuario extends Base {

    private OffsetDateTime data;
    private String diagnostico;
    private String tratamento;
    private String observacoes;

    @ManyToOne
    private Paciente paciente;
    @ManyToOne
    private Medico medico;

    public Prontuario(ProntuarioDto prontuarioDto) {
        super();
        this.data = prontuarioDto.getData();
        this.diagnostico = prontuarioDto.getDiagnostico();
        this.tratamento = prontuarioDto.getTratamento();
        this.observacoes = prontuarioDto.getTratamento();
        this.paciente = new Paciente(prontuarioDto.getPaciente());
        this.medico = new Medico(prontuarioDto.getMedico());
    }
}
