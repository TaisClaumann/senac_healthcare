package com.backend_senac.healthcare.domain;

import com.backend_senac.healthcare.domain.dto.MedicamentoDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
public class Medicamento extends Base {

    private String nome;

    @JsonIgnore
    @ManyToMany(mappedBy = "medicamentos", fetch = FetchType.LAZY)
    private List<Prescricao> prescricoes;

    public Medicamento(MedicamentoDto medicamentoDto) {
        super();
        this.nome = medicamentoDto.getNome();
        this.prescricoes = Objects.isNull(medicamentoDto.getPrescricoes()) ? null : medicamentoDto.getPrescricoes().stream().map(Prescricao::new).toList();
    }
}
