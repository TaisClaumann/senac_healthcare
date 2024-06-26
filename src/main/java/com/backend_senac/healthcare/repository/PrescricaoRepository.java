package com.backend_senac.healthcare.repository;

import com.backend_senac.healthcare.domain.Prescricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescricaoRepository extends JpaRepository<Prescricao, Long> {

}
