package com.backend_senac.healthcare.domain;

import com.backend_senac.healthcare.domain.dto.MedicamentoDto;
import com.backend_senac.healthcare.domain.dto.PrescricaoDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.OffsetDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
public class Prescricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private OffsetDateTime data;
    private String dosagem;
    private String duracao;

    @ManyToOne
    private Paciente paciente;
    @ManyToOne
    private Medico medico;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "prescricao_medicamento", joinColumns = @JoinColumn(name = "medicamento_id"), inverseJoinColumns = @JoinColumn(name = "prescricao_id"))
    private List<Medicamento> medicamentos;

    @CreatedDate
    @Column(updatable = false)
    private OffsetDateTime createdDate;

    @LastModifiedDate
    private OffsetDateTime modifiedDate;

    public Prescricao(PrescricaoDto prescricaoDto) {
        this.id = prescricaoDto.getId();
        this.data = prescricaoDto.getData();
        this.dosagem = prescricaoDto.getDosagem();
        this.duracao = prescricaoDto.getDuracao();
        this.paciente = new Paciente(prescricaoDto.getPaciente());
        this.medico = new Medico(prescricaoDto.getMedico());
        this.medicamentos = prescricaoDto.getMedicamentosDto().stream().map(Medicamento::new).toList();
        this.createdDate = prescricaoDto.getCreatedDate();
        this.modifiedDate = prescricaoDto.getModifiedDate();
    }
}