package com.backend_senac.healthcare.domain.dto;

import com.backend_senac.healthcare.domain.Medicamento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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
    @JsonIgnore
    private OffsetDateTime createdDate;
    @JsonIgnore
    private OffsetDateTime modifiedDate;

    public MedicamentoDto(Medicamento medicamento) {
        this.id = medicamento.getId();
        this.nome = medicamento.getNome();
        this.createdDate = medicamento.getCreatedDate();
        this.modifiedDate = medicamento.getModifiedDate();
    }
}
