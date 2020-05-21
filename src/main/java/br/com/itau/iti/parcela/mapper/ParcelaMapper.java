package br.com.itau.iti.parcela.mapper;

import br.com.itau.iti.parcela.model.ParcelaEntity;
import br.com.itau.iti.parcela.model.ParcelaEntrada;
import br.com.itau.iti.parcela.model.ParcelaSaida;
import br.com.itau.iti.solicitacao.mapper.SolicitacaoMapper;
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
public interface ParcelaMapper {
    ParcelaMapper INSTANCE = Mappers.getMapper(ParcelaMapper.class);

    @Mappings({
            @Mapping(target = "id", ignore = true)
    })
    ParcelaEntity converterEntradaParaEntity (ParcelaEntrada parcelaEntrada);
    List<ParcelaEntity> converterEntradasParaEntities(List<ParcelaEntrada> parcelaEntrada);

    ParcelaSaida converterEntityParaSaida(ParcelaEntity parcelaEntity);
    List<ParcelaSaida> converterEntitiesParaSaidas(List<ParcelaEntity> parcelaEntity);
}
