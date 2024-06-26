package com.backend_senac.healthcare.domain.dto;

import com.backend_senac.healthcare.domain.Paciente;
import com.backend_senac.healthcare.enums.SexoEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PacienteDto {

    private Long id;
    private String nome;
    private String dataNascimento;
    private SexoEnum sexo;
    private String telefone;
    private String endereco;
    private String email;

    @JsonIgnore
    private OffsetDateTime createdDate;
    @JsonIgnore
    private OffsetDateTime modifiedDate;

    public PacienteDto(Paciente paciente) {
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.dataNascimento = paciente.getDataNascimento();
        this.sexo = paciente.getSexo();
        this.telefone = paciente.getTelefone();
        this.endereco = paciente.getEndereco();
        this.email = paciente.getEmail();
        this.createdDate = paciente.getCreatedDate();
        this.modifiedDate = paciente.getModifiedDate();
    }
}
