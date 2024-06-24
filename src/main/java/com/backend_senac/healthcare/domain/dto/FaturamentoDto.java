package com.backend_senac.healthcare.domain.dto;

import com.backend_senac.healthcare.domain.Agendamento;
import com.backend_senac.healthcare.domain.Faturamento;
import com.backend_senac.healthcare.domain.Paciente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

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

    private OffsetDateTime createdDate;

    private OffsetDateTime modifiedDate;

    public FaturamentoDto(Faturamento faturamento) {
        this.id = faturamento.getId();
        this.valorTotal = faturamento.getValorTotal();
        this.itensFaturamento = faturamento.getItensFaturamento().stream().map(ItemFaturamentoDto::new).toList();
        this.paciente = new PacienteDto(faturamento.getPaciente());
        this.createdDate = faturamento.getCreatedDate();
        this.modifiedDate = faturamento.getModifiedDate();
    }
}
