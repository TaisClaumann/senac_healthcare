package com.backend_senac.healthcare.domain.dto;

import com.backend_senac.healthcare.domain.Faturamento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class FaturamentoDto {

    private Long id;
    private Double valorTotal;
    private PacienteDto paciente;

    @JsonIgnore
    @Builder.Default
    private List<ItemFaturamentoDto> itensFaturamento = new ArrayList<>();

    @JsonIgnore
    private OffsetDateTime createdDate;
    @JsonIgnore
    private OffsetDateTime modifiedDate;

    public FaturamentoDto(Faturamento faturamento) {
        this.id = faturamento.getId();
        this.valorTotal = faturamento.getValorTotal();
        this.paciente = Objects.isNull(faturamento.getPaciente()) ? null : new PacienteDto(faturamento.getPaciente());
        this.createdDate = faturamento.getCreatedDate();
        this.modifiedDate = faturamento.getModifiedDate();
    }
}
