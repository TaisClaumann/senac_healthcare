package com.backend_senac.healthcare.domain.dto;

import com.backend_senac.healthcare.domain.Agendamento;
import com.backend_senac.healthcare.domain.Medico;
import com.backend_senac.healthcare.domain.Prescricao;
import com.backend_senac.healthcare.domain.Prontuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class MedicoDto implements Serializable {

    private Long id;
    private String nome;
    private String especializacao;
    private String telefone;
    private String email;

    @Builder.Default
    @JsonIgnore
    private List<AgendamentoDto> agendamentos = new ArrayList<>();

    @Builder.Default
    @JsonIgnore
    private List<ProntuarioDto> prontuarios = new ArrayList<>();

    @Builder.Default
    @JsonIgnore
    private List<PrescricaoDto> prescricoes = new ArrayList<>();

    private OffsetDateTime createdDate;
    private OffsetDateTime modifiedDate;

    public MedicoDto(Medico medico) {
        this.id = medico.getId();
        this.nome = medico.getNome();
        this.especializacao = medico.getEspecializacao();
        this.telefone = medico.getTelefone();
        this.email = medico.getEmail();
        this.createdDate = medico.getCreatedDate();
        this.modifiedDate = medico.getModifiedDate();
    }
}
