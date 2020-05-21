package br.com.itau.iti.conta.model;

import br.com.itau.iti.utils.enums.StatusConta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Conta")
public class ContaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @Column(name = "numero")
    Integer numero;

    @Column(name = "agencia")
    Integer agencia;

    @Column(name = "tipo")
    String tipo;

    @Column(name = "saldo")
    Double saldo;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    StatusConta status;
}
