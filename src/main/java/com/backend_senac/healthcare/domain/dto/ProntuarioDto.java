package com.backend_senac.healthcare.domain.dto;

import com.backend_senac.healthcare.domain.Medico;
import com.backend_senac.healthcare.domain.Paciente;
import com.backend_senac.healthcare.domain.Prontuario;
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
public class ProntuarioDto {

    private Long id;

    private OffsetDateTime data;

    private String diagnostico;

    private String tratamento;

    private String observacoes;

    private PacienteDto paciente;

    private MedicoDto medico;

    private OffsetDateTime createdDate;

    private OffsetDateTime modifiedDate;

    public ProntuarioDto(Prontuario prontuario) {
        this.id = prontuario.getId();
        this.data = prontuario.getData();
        this.tratamento = prontuario.getTratamento();
        this.observacoes = prontuario.getObservacoes();
        this.paciente = new PacienteDto(prontuario.getPaciente());
        this.medico = new MedicoDto(prontuario.getMedico());
        this.createdDate = prontuario.getCreatedDate();
        this.modifiedDate = prontuario.getModifiedDate();
    }
}
