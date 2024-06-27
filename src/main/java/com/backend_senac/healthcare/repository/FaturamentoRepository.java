package com.backend_senac.healthcare.repository;

import com.backend_senac.healthcare.domain.Faturamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaturamentoRepository extends JpaRepository<Faturamento, Long> {

}
