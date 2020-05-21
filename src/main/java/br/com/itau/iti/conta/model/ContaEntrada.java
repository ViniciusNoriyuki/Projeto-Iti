package br.com.itau.iti.conta.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContaEntrada {

    Integer numero;
    Integer agencia;
    String tipo;
    Double saldo;
}
