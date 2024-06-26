package com.backend_senac.healthcare.domain.dto;

import com.backend_senac.healthcare.domain.ItemFaturamento;
import com.backend_senac.healthcare.domain.Medicamento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

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

    public MedicamentoDto(Medicamento medicamento) {
        this.id = medicamento.getId();
        this.nome = medicamento.getNome();
        this.prescricoes = Objects.isNull(medicamento.getPrescricoes()) ? null : medicamento.getPrescricoes().stream().map(PrescricaoDto::new).toList();
        this.createdDate = medicamento.getCreatedDate();
        this.modifiedDate = medicamento.getModifiedDate();
    }
}
