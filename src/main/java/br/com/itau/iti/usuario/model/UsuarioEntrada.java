package br.com.itau.iti.usuario.model;

import br.com.itau.iti.conta.model.ContaEntrada;
import br.com.itau.iti.conta.model.ContaSaida;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntrada {

    @NotNull
    String nome;
    Integer idade;
    @CPF
    String cpf;
}
