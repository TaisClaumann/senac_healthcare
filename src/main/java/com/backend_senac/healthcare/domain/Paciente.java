package com.backend_senac.healthcare.domain;

import com.backend_senac.healthcare.domain.dto.AgendamentoDto;
import com.backend_senac.healthcare.domain.dto.PacienteDto;
import com.backend_senac.healthcare.enums.SexoEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dataNascimento;

    @Enumerated(EnumType.STRING)
    private SexoEnum sexo;

    private String telefone;
    private String endereco;
    private String email;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @JsonIgnore
    @Builder.Default
    @OneToMany(mappedBy = "paciente")
    private List<Faturamento> faturamentos = new ArrayList<>();

    @JsonIgnore
    @Builder.Default
    @OneToMany(mappedBy = "paciente")
    private List<Agendamento> agendamentos = new ArrayList<>();

    @JsonIgnore
    @Builder.Default
    @OneToMany(mappedBy = "paciente")
    private List<Prontuario> prontuarios = new ArrayList<>();

    @JsonIgnore
    @Builder.Default
    @OneToMany(mappedBy = "paciente")
    private List<Prescricao> prescricoes = new ArrayList<>();

    public Paciente(PacienteDto pacienteDto) {
        this.id = pacienteDto.getId();
        this.nome = pacienteDto.getNome();
        this.dataNascimento = pacienteDto.getDataNascimento();
        this.email = pacienteDto.getEmail();
        this.telefone = pacienteDto.getTelefone();
        this.endereco = pacienteDto.getEndereco();
        this.createdDate = pacienteDto.getCreatedDate();
        this.modifiedDate = pacienteDto.getModifiedDate();
    }
}
