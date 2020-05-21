package br.com.itau.iti.parcela.model;

import br.com.itau.iti.utils.enums.StatusParcela;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParcelaSaida {

    private Long id;
    private Double valorParcela;
    private StatusParcela status;
}
