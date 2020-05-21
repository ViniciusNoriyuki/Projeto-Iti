package br.com.itau.iti.usuario.model;

import br.com.itau.iti.conta.model.ContaEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Usuario")
public class UsuarioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(name = "nome")
	String nome;

	@Column(name = "cpf")
	String cpf;

	@Column(name = "idade")
	Integer idade;

	@OneToMany
	List<ContaEntity> listaContas;
}
