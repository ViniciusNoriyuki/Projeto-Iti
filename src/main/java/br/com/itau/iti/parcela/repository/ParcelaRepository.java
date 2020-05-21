package br.com.itau.iti.parcela.repository;

import br.com.itau.iti.parcela.model.ParcelaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelaRepository extends JpaRepository<ParcelaEntity, Long> {
}
