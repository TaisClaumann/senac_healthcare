package com.backend_senac.healthcare.repository;

import com.backend_senac.healthcare.domain.ItemFaturamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemFaturamentoRepository extends JpaRepository<ItemFaturamento, Long> {

}
