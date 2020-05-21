package br.com.itau.iti.conta.controller;

import br.com.itau.iti.conta.facade.ContaFacade;
import br.com.itau.iti.conta.model.ContaEntrada;
import br.com.itau.iti.conta.model.ContaSaida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "iti/conta", produces = "application/json")
@Configuration
@CrossOrigin
public class ContaController {

    @Autowired
    public ContaFacade contaFacade;

    @PostMapping
    public ContaSaida salvar(@RequestBody ContaEntrada contaEntrada) throws Exception {

        ContaSaida saida = contaFacade.buscarSolicitacao(contaEntrada);
        return saida;

    }
}
