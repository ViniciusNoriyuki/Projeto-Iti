package br.com.itau.iti.solicitacao.facade;

import br.com.itau.iti.parcela.mapper.ParcelaMapper;
import br.com.itau.iti.parcela.model.ParcelaEntity;
import br.com.itau.iti.parcela.model.ParcelaEntrada;
import br.com.itau.iti.parcela.model.ParcelaSaida;
import br.com.itau.iti.parcela.repository.ParcelaRepository;
import br.com.itau.iti.solicitacao.mapper.SolicitacaoMapper;
import br.com.itau.iti.solicitacao.model.SolicitacaoEntity;
import br.com.itau.iti.solicitacao.model.SolicitacaoEntrada;
import br.com.itau.iti.solicitacao.model.SolicitacaoSaida;
import br.com.itau.iti.solicitacao.repository.SolicitacaoRepository;
import br.com.itau.iti.usuario.facade.UsuarioFacade;
import br.com.itau.iti.usuario.model.UsuarioEntity;
import br.com.itau.iti.usuario.repository.UsuarioRepository;
import br.com.itau.iti.utils.enums.StatusParcela;
import com.sun.org.apache.xerces.internal.impl.xs.XSAnnotationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitacaoFacade {

    @Autowired
    SolicitacaoRepository solicitacaoRepository;
    @Autowired
    UsuarioFacade usuarioFacade;
    @Autowired
    ParcelaRepository parcelaRepository;

    public SolicitacaoSaida buscarSolicitacao(SolicitacaoEntrada solicitacaoEntrada) throws Exception {

        // ENTRADA PARA ENTIDADE =>
        UsuarioEntity solicitador = usuarioFacade.retornarUsuarioEntity(solicitacaoEntrada.getSolicitador());
        UsuarioEntity pagador = usuarioFacade.retornarUsuarioEntity(solicitacaoEntrada.getPagador());

        List<ParcelaEntrada> listaParcelasEntrada = preencerListaParcelas(solicitacaoEntrada);
        List<ParcelaEntity> listaParcelaEntity = ParcelaMapper.INSTANCE.converterEntradasParaEntities(listaParcelasEntrada);
        listaParcelaEntity = parcelaRepository.saveAll(listaParcelaEntity);

        SolicitacaoEntity entidade = SolicitacaoMapper.INSTANCE.converterEntradaParaEntity(solicitacaoEntrada, solicitador, pagador, listaParcelaEntity);

        // ENTIDADE PARA BANCO =>
        entidade = solicitacaoRepository.save(entidade);

        // ENTIDADE PARA SAIDA =>
        List<ParcelaSaida> listaParcelasSaida = ParcelaMapper.INSTANCE.converterEntitiesParaSaidas(listaParcelaEntity);
        SolicitacaoSaida saida = SolicitacaoMapper.INSTANCE.converterEntityParaSaida(entidade, listaParcelasSaida);

        return saida;
    }

    public List<ParcelaEntrada> preencerListaParcelas(SolicitacaoEntrada solicitacaoEntrada){
        List<ParcelaEntrada> listaParcelas = new ArrayList<>();
        Double valorParcela = solicitacaoEntrada.getValor() / solicitacaoEntrada.getQtdParcelas();
        for (int i = 0; i < solicitacaoEntrada.getQtdParcelas(); i++){
            ParcelaEntrada parcelaEntrada = new ParcelaEntrada(valorParcela, StatusParcela.ABERTA);
            listaParcelas.add(parcelaEntrada);
        }
        return listaParcelas;
    }

    public List<SolicitacaoSaida> listaSolicitacoesUsuario(Long idUsuario) throws Exception {
        UsuarioEntity entidade = usuarioFacade.retornarUsuarioEntity(idUsuario);
        List<SolicitacaoEntity> listaSolicitacoes = solicitacaoRepository.findBysolicitador(entidade);

        List<SolicitacaoSaida> saida = SolicitacaoMapper.INSTANCE.converterEntitiesParaSaida(listaSolicitacoes);

        return saida;
    }

    public List<SolicitacaoSaida> listaPagamentosUsuario(Long idUsuario) throws Exception {
        UsuarioEntity entidade = usuarioFacade.retornarUsuarioEntity(idUsuario);
        List<SolicitacaoEntity> listaSolicitacoes = solicitacaoRepository.findBypagador(entidade);

        List<SolicitacaoSaida> saida = SolicitacaoMapper.INSTANCE.converterEntitiesParaSaida(listaSolicitacoes);

        return saida;
    }

    public SolicitacaoSaida deletarSolicitacao(Long idSolicitacao) throws Exception{
        SolicitacaoEntity entidade;
        Optional<SolicitacaoEntity> retornoBanco = solicitacaoRepository.findById(idSolicitacao);

        if (!retornoBanco.isPresent()) {
            throw new Exception("Nao encontrado!");
        }
        entidade = retornoBanco.get();

        entidade.setStatusSolicitacao("CANCELADA");

        entidade = solicitacaoRepository.save(entidade);

        SolicitacaoSaida saida = SolicitacaoMapper.INSTANCE.converterEntidadeParaSaida(entidade);

        return saida;
    }
}
