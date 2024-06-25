package com.backend_senac.healthcare.domain.dto;

import com.backend_senac.healthcare.domain.Medico;
import com.backend_senac.healthcare.domain.Paciente;
import com.backend_senac.healthcare.domain.Prescricao;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.OffsetDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class PrescricaoDto {

    private Long id;

    private OffsetDateTime data;

    private String dosagem;

    private String duracao;

    private PacienteDto paciente;

    private MedicoDto medico;

    private List<MedicamentoDto> medicamentosDto;

    private OffsetDateTime createdDate;

    private OffsetDateTime modifiedDate;

    public PrescricaoDto(Prescricao prescricao) {
        this.id = prescricao.getId();
        this.dosagem = prescricao.getDosagem();
        this.duracao = prescricao.getDuracao();
        this.paciente = new PacienteDto(prescricao.getPaciente());
        this.medico = new MedicoDto(prescricao.getMedico());
        this.medicamentosDto = prescricao.getMedicamentos().stream().map(MedicamentoDto::new).toList();
        this.createdDate = prescricao.getCreatedDate();
        this.modifiedDate = prescricao.getModifiedDate();
    }
}