package com.backend_senac.healthcare.domain.dto;

import com.backend_senac.healthcare.domain.Agendamento;
import com.backend_senac.healthcare.domain.Prescricao;
import com.backend_senac.healthcare.domain.Prontuario;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class MedicoDto implements Serializable {

    private Long id;
    private String nome;
    private String especializacao;
    private String telefone;
    private String email;

    @Builder.Default
    private List<Agendamento> agendamentos = new ArrayList<>();

    @Builder.Default
    private List<Prontuario> prontuarios = new ArrayList<>();

    @Builder.Default
    private List<Prescricao> prescricoes = new ArrayList<>();

    private OffsetDateTime createdDate;
    private OffsetDateTime modifiedDate;
}
