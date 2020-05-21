package br.com.itau.iti.solicitacao.model;

import br.com.itau.iti.parcela.model.ParcelaSaida;
import br.com.itau.iti.usuario.model.UsuarioSaida;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SolicitacaoSaida {

    private Long id;
    private UsuarioSaida solicitador;
    private UsuarioSaida pagador;
    private Double valor;
    private Integer qtdParcelas;
    private String formaPagamento;
    private String statusSolicitacao;
    private List<ParcelaSaida> listaParcelas;

}
