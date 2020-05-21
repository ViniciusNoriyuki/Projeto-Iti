package br.com.itau.iti.conta.repository;

import br.com.itau.iti.conta.model.ContaEntity;
import br.com.itau.iti.utils.enums.StatusConta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContaRepository extends JpaRepository<ContaEntity, Long> {
    List<ContaEntity> findByStatus(StatusConta statusConta);
}

