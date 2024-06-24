package com.backend_senac.healthcare.domain.dto;

import com.backend_senac.healthcare.domain.Faturamento;
import com.backend_senac.healthcare.domain.ItemFaturamento;
import com.backend_senac.healthcare.enums.TipoItemFaturamentoEnum;
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
public class ItemFaturamentoDto {

    private Long id;

    private String descricao;

    private Double valor;

    private FaturamentoDto faturamentoDto;

    @Enumerated(EnumType.STRING)
    private TipoItemFaturamentoEnum tipo;

    private OffsetDateTime createdDate;

    private OffsetDateTime modifiedDate;

    public ItemFaturamentoDto(ItemFaturamento itemFaturamento) {
        this.id = itemFaturamento.getId();
        this.createdDate = itemFaturamento.getCreatedDate();
        this.modifiedDate = itemFaturamento.getModifiedDate();
    }
}
