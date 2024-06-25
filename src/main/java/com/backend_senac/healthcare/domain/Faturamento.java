package com.backend_senac.healthcare.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
public class Faturamento extends Base {

    private Double valorTotal;

    @ManyToOne
    private Paciente paciente;

    @JsonIgnore
    @Builder.Default
    @OneToMany(mappedBy = "faturamento")
    private List<ItemFaturamento> itensFaturamento = new ArrayList<>();
}
