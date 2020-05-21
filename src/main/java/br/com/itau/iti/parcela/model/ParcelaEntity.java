package br.com.itau.iti.parcela.model;

import br.com.itau.iti.utils.enums.StatusParcela;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Parcelas")
public class ParcelaEntity {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @Column(name = "valor")
    Double valorParcela;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    StatusParcela status;
}
