package com.backend_senac.healthcare.domain;

import com.backend_senac.healthcare.enums.StatusAgendamento;
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
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private OffsetDateTime data;

    @Enumerated(EnumType.STRING)
    private StatusAgendamento status;

    @ManyToOne
    private Paciente paciente;
    @ManyToOne
    private Medico medico;

    @CreatedDate
    @Column(updatable = false)
    private OffsetDateTime createdDate;

    @LastModifiedDate
    private OffsetDateTime modifiedDate;
}
