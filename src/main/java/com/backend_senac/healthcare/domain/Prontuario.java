package com.backend_senac.healthcare.domain;

import com.backend_senac.healthcare.domain.dto.ProntuarioDto;
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
@Entity
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private OffsetDateTime data;
    private String diagnostico;
    private String tratamento;
    private String observacoes;

    @ManyToOne
    private Paciente paciente;
    @ManyToOne
    private Medico medico;

    @CreatedDate
    @Column(updatable = false)
    private OffsetDateTime createdDate;

    @LastModifiedDate
    private OffsetDateTime modifiedDate;

    public Prontuario(ProntuarioDto prontuarioDto) {
        this.id = prontuarioDto.getId();
        this.data = prontuarioDto.getData();
        this.diagnostico = prontuarioDto.getDiagnostico();
        this.tratamento = prontuarioDto.getTratamento();
        this.observacoes = prontuarioDto.getTratamento();
        this.paciente = new Paciente(prontuarioDto.getPaciente());
        this.medico = new Medico(prontuarioDto.getMedico());
        this.createdDate = prontuarioDto.getCreatedDate();
        this.modifiedDate = prontuarioDto.getModifiedDate();
    }
}
