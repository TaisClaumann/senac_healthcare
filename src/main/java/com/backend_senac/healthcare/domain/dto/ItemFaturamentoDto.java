package com.backend_senac.healthcare.domain.dto;

import com.backend_senac.healthcare.domain.ItemFaturamento;
import com.backend_senac.healthcare.enums.TipoItemFaturamentoEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class ItemFaturamentoDto {

    private Long id;

    private String descricao;

    private Double valor;

    private FaturamentoDto faturamentoDto;

    @Enumerated(EnumType.STRING)
    private TipoItemFaturamentoEnum tipo;

    @JsonIgnore
    private OffsetDateTime createdDate;
    @JsonIgnore
    private OffsetDateTime modifiedDate;

    public ItemFaturamentoDto(ItemFaturamento itemFaturamento) {
        this.id = itemFaturamento.getId();
        this.descricao = itemFaturamento.getDescricao();
        this.valor = itemFaturamento.getValor();
        this.tipo = itemFaturamento.getTipo();
        this.faturamentoDto = new FaturamentoDto(itemFaturamento.getFaturamento());
        this.createdDate = itemFaturamento.getCreatedDate();
        this.modifiedDate = itemFaturamento.getModifiedDate();
    }
}
