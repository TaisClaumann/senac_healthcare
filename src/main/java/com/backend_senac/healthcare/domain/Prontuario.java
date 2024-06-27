package com.backend_senac.healthcare.domain;

import com.backend_senac.healthcare.domain.dto.ProntuarioDto;
import com.backend_senac.healthcare.utils.DataUtils;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
public class Prontuario extends Base {

    private String diagnostico;
    private String tratamento;
    private String observacoes;
    private String convenio;
    private OffsetDateTime dataEntrada;
    private OffsetDateTime dataAlta;

    @ManyToOne
    private Paciente paciente;
    @ManyToOne
    private Medico medico;

    public Prontuario(ProntuarioDto prontuarioDto) {
        super();
        this.diagnostico = prontuarioDto.getDiagnostico();
        this.tratamento = prontuarioDto.getTratamento();
        this.observacoes = prontuarioDto.getTratamento();
        this.paciente = new Paciente(prontuarioDto.getPaciente());
        this.medico = new Medico(prontuarioDto.getMedico());
        this.convenio = prontuarioDto.getConvenio();
        this.dataAlta = DataUtils.stringToOffsetDateTime(prontuarioDto.getDataAlta());
        this.dataEntrada = DataUtils.stringToOffsetDateTime(prontuarioDto.getDataEntrada());
    }
}
