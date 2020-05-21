package br.com.itau.iti.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.itau.iti.usuario.model.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}

