package br.com.itau.iti.solicitacao.model;

import br.com.itau.iti.parcela.model.ParcelaEntity;
import br.com.itau.iti.usuario.model.UsuarioEntity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Solicitacao")
public class SolicitacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @OneToOne
    UsuarioEntity solicitador;

    @OneToOne
    UsuarioEntity pagador;

    @Column(name = "valor")
    Double valor;

    @Column(name = "qtdParcelas")
    Integer qtdParcelas;

    @Column(name = "formaPagamento")
    String formaPagamento;

    @Column(name = "statusSolicitacao")
    String statusSolicitacao = "ABERTA";

    @OneToMany
    List<ParcelaEntity> listaParcelas;

}
