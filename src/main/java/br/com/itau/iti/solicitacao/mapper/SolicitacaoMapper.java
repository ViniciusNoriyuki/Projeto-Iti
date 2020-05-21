package br.com.itau.iti.solicitacao.mapper;

import br.com.itau.iti.parcela.model.ParcelaEntity;
import br.com.itau.iti.parcela.model.ParcelaSaida;
import br.com.itau.iti.solicitacao.model.SolicitacaoEntity;
import br.com.itau.iti.solicitacao.model.SolicitacaoEntrada;
import br.com.itau.iti.solicitacao.model.SolicitacaoSaida;
import br.com.itau.iti.usuario.model.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SolicitacaoMapper {

    SolicitacaoMapper INSTANCE = Mappers.getMapper(SolicitacaoMapper.class);

    @Mappings({
            @Mapping(target = "solicitador", source = "solicitador"),
            @Mapping(target = "pagador", source = "pagador"),
            @Mapping(target = "id", ignore = true)
    })
    SolicitacaoEntity converterEntradaParaEntity (SolicitacaoEntrada entrada, UsuarioEntity solicitador, UsuarioEntity pagador, List<ParcelaEntity> listaParcelas);
    SolicitacaoSaida converterEntidadeParaSaida (SolicitacaoEntity entidade);
    SolicitacaoSaida converterEntityParaSaida (SolicitacaoEntity entidade, List<ParcelaSaida> listaParcelas);

    List<SolicitacaoSaida> converterEntitiesParaSaida (List<SolicitacaoEntity> listaSolicitacao);
}
