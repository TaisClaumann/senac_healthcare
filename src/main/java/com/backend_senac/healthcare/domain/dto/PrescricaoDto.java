package com.backend_senac.healthcare.domain.dto;

import com.backend_senac.healthcare.domain.Prescricao;
import com.backend_senac.healthcare.utils.DataUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class PrescricaoDto {

    private Long id;

    private String dosagem;

    private String duracao;

    private PacienteDto paciente;

    private MedicoDto medico;

    private List<MedicamentoDto> medicamentosDto;

    private String data;

    @JsonIgnore
    private OffsetDateTime modifiedDate;

    public PrescricaoDto(Prescricao prescricao) {
        this.id = prescricao.getId();
        this.dosagem = prescricao.getDosagem();
        this.duracao = prescricao.getDuracao();
        this.paciente = new PacienteDto(prescricao.getPaciente());
        this.medico = new MedicoDto(prescricao.getMedico());
        this.medicamentosDto = prescricao.getMedicamentos().stream().map(MedicamentoDto::new).toList();
        this.data = Objects.isNull(prescricao.getCreatedDate()) ? null : DataUtils.offsetDateTimeToString(prescricao.getCreatedDate());
        this.modifiedDate = prescricao.getModifiedDate();
    }
}