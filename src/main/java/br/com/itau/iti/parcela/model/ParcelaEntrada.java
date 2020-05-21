package br.com.itau.iti.parcela.model;

import br.com.itau.iti.utils.enums.StatusParcela;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ParcelaEntrada {
    Double valorParcela;
    StatusParcela status;
}
