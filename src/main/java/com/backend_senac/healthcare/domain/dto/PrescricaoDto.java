package com.backend_senac.healthcare.domain.dto;

import com.backend_senac.healthcare.domain.Medico;
import com.backend_senac.healthcare.domain.Paciente;
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

    private Paciente paciente;

    private Medico medico;

    private List<MedicamentoDto> medicamentoDtos;

    private OffsetDateTime createdDate;

    private OffsetDateTime modifiedDate;
}