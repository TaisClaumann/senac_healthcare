package com.backend_senac.healthcare.domain;

import com.backend_senac.healthcare.enums.TipoItemFaturamentoEnum;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.OffsetDateTime;

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
