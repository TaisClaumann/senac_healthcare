package com.backend_senac.healthcare.repository;

import com.backend_senac.healthcare.domain.Medicamento;
import com.backend_senac.healthcare.domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
}
