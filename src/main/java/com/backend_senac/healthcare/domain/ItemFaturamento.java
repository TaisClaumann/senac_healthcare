package com.backend_senac.healthcare.domain;

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
@Entity
public class ItemFaturamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Double valor;

    @ManyToOne
    private Faturamento faturamento;

    @Enumerated(EnumType.STRING)
    private TipoItemFaturamentoEnum tipo;

    @CreatedDate
    @Column(updatable = false)
    private OffsetDateTime createdDate;

    @LastModifiedDate
    private OffsetDateTime modifiedDate;
}
