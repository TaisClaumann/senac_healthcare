package com.backend_senac.healthcare.domain;

import com.backend_senac.healthcare.enums.TipoItemFaturamentoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
public class ItemFaturamento extends Base {

    private String descricao;
    private Double valor;

    @ManyToOne
    private Faturamento faturamento;

    @Enumerated(EnumType.STRING)
    private TipoItemFaturamentoEnum tipo;
}
