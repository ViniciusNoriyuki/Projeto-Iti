package br.com.itau.iti.solicitacao.model;

import br.com.itau.iti.parcela.model.ParcelaEntrada;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SolicitacaoEntrada {

    Long solicitador;
    Long pagador;
    Double valor;
    Integer qtdParcelas;
    String formaPagamento;
}
