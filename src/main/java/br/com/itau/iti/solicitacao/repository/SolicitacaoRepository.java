package br.com.itau.iti.solicitacao.repository;

import br.com.itau.iti.solicitacao.model.SolicitacaoEntity;
import br.com.itau.iti.usuario.model.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitacaoRepository extends JpaRepository<SolicitacaoEntity, Long> {
    public List<SolicitacaoEntity> findBysolicitador(UsuarioEntity solicitador);
    public List<SolicitacaoEntity> findBypagador(UsuarioEntity solicitador);
}
