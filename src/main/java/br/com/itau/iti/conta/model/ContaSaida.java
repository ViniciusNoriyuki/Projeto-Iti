package br.com.itau.iti.conta.model;

import br.com.itau.iti.utils.enums.StatusConta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContaSaida {

    private Long id;
    private Integer numero;
    private Integer agencia;
    private String tipo;
    private Double saldo;
    private StatusConta status;
}
