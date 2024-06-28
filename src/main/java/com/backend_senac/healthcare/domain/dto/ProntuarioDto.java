package com.backend_senac.healthcare.domain.dto;

import com.backend_senac.healthcare.domain.Prontuario;
import com.backend_senac.healthcare.utils.DataUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class ProntuarioDto {

    private Long id;
    private String diagnostico;
    private String tratamento;
    private String observacoes;
    private String convenio;

    private PacienteDto paciente;
    private MedicoDto medico;

    private String dataEntrada;
    private String dataAlta;

    @JsonIgnore
    private OffsetDateTime createdDate;
    @JsonIgnore
    private OffsetDateTime modifiedDate;

    public ProntuarioDto(Prontuario prontuario) {
        this.id = prontuario.getId();
        this.tratamento = prontuario.getTratamento();
        this.observacoes = prontuario.getObservacoes();
        this.paciente = Objects.nonNull(prontuario.getPaciente()) ? new PacienteDto(prontuario.getPaciente()) : null;
        this.medico = Objects.nonNull(prontuario.getMedico()) ? new MedicoDto(prontuario.getMedico()) : null;
        this.createdDate = prontuario.getCreatedDate();
        this.modifiedDate = prontuario.getModifiedDate();
        this.dataEntrada = DataUtils.offsetDateTimeToString(prontuario.getDataEntrada());
        this.dataAlta = DataUtils.offsetDateTimeToString(prontuario.getDataAlta());
        this.convenio = prontuario.getConvenio();
        this.diagnostico = prontuario.getDiagnostico();
    }
}
