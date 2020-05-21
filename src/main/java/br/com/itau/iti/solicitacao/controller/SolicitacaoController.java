package br.com.itau.iti.solicitacao.controller;

import br.com.itau.iti.solicitacao.facade.SolicitacaoFacade;
import br.com.itau.iti.solicitacao.model.SolicitacaoEntrada;
import br.com.itau.iti.solicitacao.model.SolicitacaoSaida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "iti/solicitacao", produces = "application/json")
@Configuration
@CrossOrigin
public class SolicitacaoController {

    @Autowired
    public SolicitacaoFacade solicitacaoFacade;

    @PostMapping
    public SolicitacaoSaida salvar(@RequestBody SolicitacaoEntrada solicitacaoEntrada) throws Exception {

        SolicitacaoSaida saida = solicitacaoFacade.buscarSolicitacao(solicitacaoEntrada);
        return saida;

    }

    @GetMapping("/{id}/solicitacoes")
    public List<SolicitacaoSaida> listaSolicitacoesUsuario(@PathVariable Long id) throws Exception {
        List<SolicitacaoSaida> saida = solicitacaoFacade.listaSolicitacoesUsuario(id);

        return saida;
    }

    @GetMapping("/{id}/pagamentos")
    public List<SolicitacaoSaida> listaPagamentosUsuario(@PathVariable Long id) throws Exception {
        List<SolicitacaoSaida> saida = solicitacaoFacade.listaPagamentosUsuario(id);

        return saida;
    }

    @PatchMapping("/{id}/deletar")
    public SolicitacaoSaida deletarSolicitacao(@PathVariable Long id) throws Exception{
        SolicitacaoSaida saida = solicitacaoFacade.deletarSolicitacao(id);

        return saida;
    }
}
