package br.com.itau.iti.usuario.facade;

import br.com.itau.iti.conta.model.ContaEntity;
import br.com.itau.iti.conta.repository.ContaRepository;
import br.com.itau.iti.usuario.mapper.UsuarioMapper;
import br.com.itau.iti.usuario.model.UsuarioEntity;
import br.com.itau.iti.usuario.model.UsuarioEntrada;
import br.com.itau.iti.usuario.model.UsuarioSaida;
import br.com.itau.iti.usuario.repository.UsuarioRepository;
import br.com.itau.iti.utils.enums.StatusConta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioFacade {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    ContaRepository contaRepository;

    public UsuarioSaida buscarUsuario(UsuarioEntrada entrada) {

        // ENTRADA PARA ENTIDADE =>
        List<ContaEntity> listaContasAguardando = contaRepository.findByStatus(StatusConta.AGUARDANDO);
        listaContasAguardando.get(0).setStatus(StatusConta.ABERTA);

        List<ContaEntity> listaContas = new ArrayList<>();
        listaContas.add(listaContasAguardando.get(0));
        UsuarioEntity entidade = UsuarioMapper.Instance.converterEntradaParaEntity(entrada, listaContas);

        // ENTIDADE PARA BANCO =>
        entidade = usuarioRepository.save(entidade);

        // ENTIDADE PARA SAIDA =>
       UsuarioSaida saida = UsuarioMapper.Instance.converterEntityParaSaida(entidade);

        return saida;
    }

    public UsuarioSaida alterarIdade(Long idUsuario , UsuarioEntrada entrada) throws Exception {

        UsuarioEntity entidade;
        Optional<UsuarioEntity> retornoBanco = usuarioRepository.findById(idUsuario);
        if (!retornoBanco.isPresent()){
            throw new Exception("Nao encontrado");

        }

        entidade = retornoBanco.get();

        entidade.setIdade(entrada.getIdade());

        entidade = usuarioRepository.save(entidade);

        UsuarioSaida saida = UsuarioMapper.Instance.converterEntityParaSaida(entidade);

        return saida;
    }

    public UsuarioEntity retornarUsuarioEntity(Long idUsuario) throws Exception {
        UsuarioEntity entidade;
        Optional<UsuarioEntity> retornoBanco = usuarioRepository.findById(idUsuario);

        if (!retornoBanco.isPresent()) {
            throw new Exception("Nao encontrado!");
        }
        entidade = retornoBanco.get();

        return entidade;
    }
    
    public List<UsuarioSaida> listarUsuarios() {

        List<UsuarioEntity> lista = usuarioRepository.findAll();

        List<UsuarioSaida> listaSaida = new ArrayList<>();
        for (UsuarioEntity saida : lista) {
            listaSaida.add (UsuarioMapper.Instance.converterEntityParaSaida(saida));
        }

        return listaSaida;
    }
}
