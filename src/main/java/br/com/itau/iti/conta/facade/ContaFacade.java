package br.com.itau.iti.conta.facade;

import br.com.itau.iti.conta.mapper.ContaMapper;
import br.com.itau.iti.conta.model.ContaEntity;
import br.com.itau.iti.conta.model.ContaEntrada;
import br.com.itau.iti.conta.model.ContaSaida;
import br.com.itau.iti.conta.repository.ContaRepository;
import br.com.itau.iti.solicitacao.mapper.SolicitacaoMapper;
import br.com.itau.iti.solicitacao.model.SolicitacaoEntity;
import br.com.itau.iti.solicitacao.model.SolicitacaoEntrada;
import br.com.itau.iti.solicitacao.model.SolicitacaoSaida;
import br.com.itau.iti.solicitacao.repository.SolicitacaoRepository;
import br.com.itau.iti.usuario.facade.UsuarioFacade;
import br.com.itau.iti.usuario.model.UsuarioEntity;
import br.com.itau.iti.usuario.model.UsuarioEntrada;
import br.com.itau.iti.utils.enums.StatusConta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContaFacade {

    @Autowired
    ContaRepository contaRepository;

    public ContaSaida buscarSolicitacao(ContaEntrada contaEntrada) throws Exception {

        // ENTRADA PARA ENTIDADE =>
        ContaEntity entidade = ContaMapper.INSTANCE.converterEntradaParaEntity(contaEntrada);
        entidade.setStatus(StatusConta.AGUARDANDO);

        // ENTIDADE PARA BANCO =>
        entidade = contaRepository.save(entidade);

        // ENTIDADE PARA SAIDA =>
        ContaSaida saida = ContaMapper.INSTANCE.converterEntityParaSaida(entidade);

        return saida;
    }
}
