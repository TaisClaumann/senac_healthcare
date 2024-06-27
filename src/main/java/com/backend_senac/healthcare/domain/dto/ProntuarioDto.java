package com.backend_senac.healthcare.domain.dto;

import com.backend_senac.healthcare.domain.Prontuario;
import com.backend_senac.healthcare.utils.DataUtils;
import lombok.*;

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
    private String convenio;

    private PacienteDto paciente;
    private MedicoDto medico;

    private String dataEntrada;
    private String dataAlta;

    private OffsetDateTime createdDate;
    private OffsetDateTime modifiedDate;

    public ProntuarioDto(Prontuario prontuario) {
        this.id = prontuario.getId();
        this.tratamento = prontuario.getTratamento();
        this.observacoes = prontuario.getObservacoes();
        this.paciente = new PacienteDto(prontuario.getPaciente());
        this.medico = new MedicoDto(prontuario.getMedico());
        this.createdDate = prontuario.getCreatedDate();
        this.modifiedDate = prontuario.getModifiedDate();
        this.dataEntrada = DataUtils.offsetDateTimeToString(prontuario.getDataEntrada());
        this.dataAlta = DataUtils.offsetDateTimeToString(prontuario.getDataAlta());
    }
}
