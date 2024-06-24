package com.backend_senac.healthcare.domain.dto;

import com.backend_senac.healthcare.domain.Medico;
import com.backend_senac.healthcare.domain.Paciente;
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

    private Paciente paciente;

    private Medico medico;

    private OffsetDateTime createdDate;

    private OffsetDateTime modifiedDate;
}
