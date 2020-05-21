package br.com.itau.iti.usuario.mapper;


import br.com.itau.iti.conta.model.ContaEntity;
import br.com.itau.iti.usuario.model.UsuarioEntity;
import br.com.itau.iti.usuario.model.UsuarioEntrada;
import br.com.itau.iti.usuario.model.UsuarioSaida;
import br.com.itau.iti.usuario.repository.UsuarioRepository;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper Instance = Mappers.getMapper(UsuarioMapper.class);

    UsuarioEntity converterEntradaParaEntity (UsuarioEntrada entrada, List<ContaEntity> listaContas);
    UsuarioSaida converterEntityParaSaida (UsuarioEntity entidade);


}
