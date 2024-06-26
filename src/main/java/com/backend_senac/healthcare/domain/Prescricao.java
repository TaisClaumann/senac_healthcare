package com.backend_senac.healthcare.domain;

import com.backend_senac.healthcare.domain.dto.PrescricaoDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
public class Prescricao extends Base {

    private String dosagem;
    private String duracao;

    @ManyToOne
    private Paciente paciente;
    @ManyToOne
    private Medico medico;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "prescricao_medicamento", joinColumns = @JoinColumn(name = "medicamento_id"), inverseJoinColumns = @JoinColumn(name = "prescricao_id"))
    private List<Medicamento> medicamentos;

    public Prescricao(PrescricaoDto prescricaoDto) {
        super();
        this.dosagem = prescricaoDto.getDosagem();
        this.duracao = prescricaoDto.getDuracao();
        this.paciente = new Paciente(prescricaoDto.getPaciente());
        this.medico = new Medico(prescricaoDto.getMedico());
        this.medicamentos = Objects.isNull(prescricaoDto.getMedicamentosDto()) ? null
                : prescricaoDto.getMedicamentosDto().stream().map(Medicamento::new).toList();
    }
}