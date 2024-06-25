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
public class Medico extends Base {

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

    public Medico(MedicoDto medicoDto) {
        super();
        this.nome = medicoDto.getNome();
        this.especializacao = medicoDto.getEspecializacao();
        this.telefone = medicoDto.getTelefone();
        this.email = medicoDto.getEmail();
        this.agendamentos = medicoDto.getAgendamentos().stream().map(Agendamento::new).toList();
        this.prontuarios = medicoDto.getProntuarios().stream().map(Prontuario::new).toList();
        this.prescricoes = medicoDto.getPrescricoes().stream().map(Prescricao::new).toList();
    }
}
