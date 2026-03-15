package com.thiago.farme_check.repository;

import com.thiago.farme_check.entity.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
    Medicamento findByNomeMedicamento (String nome);
}

