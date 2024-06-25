package com.backend_senac.healthcare.domain;

import com.backend_senac.healthcare.domain.dto.AgendamentoDto;
import com.backend_senac.healthcare.domain.dto.MedicoDto;
import com.backend_senac.healthcare.domain.dto.PrescricaoDto;
import com.backend_senac.healthcare.domain.dto.ProntuarioDto;
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
@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String especializacao;
    private String telefone;
    private String email;

    @JsonIgnore
    @Builder.Default
    @OneToMany(mappedBy = "medico")
    private List<Agendamento> agendamentos = new ArrayList<>();

    @JsonIgnore
    @Builder.Default
    @OneToMany(mappedBy = "medico")
    private List<Prontuario> prontuarios = new ArrayList<>();

    @JsonIgnore
    @Builder.Default
    @OneToMany(mappedBy = "medico")
    private List<Prescricao> prescricoes = new ArrayList<>();

    @CreatedDate
    @Column(updatable = false)
    private OffsetDateTime createdDate;

    @LastModifiedDate
    private OffsetDateTime modifiedDate;

    public Medico(MedicoDto medicoDto) {
        this.id = medicoDto.getId();
        this.nome = medicoDto.getNome();
        this.especializacao = medicoDto.getEspecializacao();
        this.telefone = medicoDto.getEspecializacao();
        this.email = medicoDto.getEmail();
        this.agendamentos = medicoDto.getAgendamentos().stream().map(Agendamento::new).toList();
        this.prontuarios = medicoDto.getProntuarios().stream().map(Prontuario::new).toList();
        this.prescricoes = medicoDto.getPrescricoes().stream().map(Prescricao::new).toList();
        this.createdDate = medicoDto.getCreatedDate();
        this.modifiedDate = medicoDto.getModifiedDate();
    }
}
