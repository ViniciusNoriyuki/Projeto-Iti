package br.com.itau.iti.usuario.model;

import br.com.itau.iti.conta.model.ContaSaida;
import br.com.itau.iti.parcela.model.ParcelaSaida;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioSaida {

    private Long id;
    private String nome;
    private Integer idade;
    private String cpf;
    private List<ContaSaida> listaContas;
}
