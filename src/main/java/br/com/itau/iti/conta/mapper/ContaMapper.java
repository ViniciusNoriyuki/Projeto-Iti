package br.com.itau.iti.conta.mapper;

import br.com.itau.iti.conta.model.ContaEntity;
import br.com.itau.iti.conta.model.ContaEntrada;
import br.com.itau.iti.conta.model.ContaSaida;
import br.com.itau.iti.usuario.mapper.UsuarioMapper;
import br.com.itau.iti.usuario.model.UsuarioEntity;
import br.com.itau.iti.usuario.model.UsuarioEntrada;
import br.com.itau.iti.usuario.model.UsuarioSaida;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContaMapper {

    ContaMapper INSTANCE = Mappers.getMapper(ContaMapper.class);

    ContaEntity converterEntradaParaEntity (ContaEntrada entrada);
    ContaSaida converterEntityParaSaida (ContaEntity entidade);
}
