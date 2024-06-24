package com.backend_senac.healthcare.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class MedicamentoDto {

    private Long id;

    private String nome;

    @JsonIgnore
    private List<PrescricaoDto> prescricoes;

    private OffsetDateTime createdDate;

    private OffsetDateTime modifiedDate;
}
