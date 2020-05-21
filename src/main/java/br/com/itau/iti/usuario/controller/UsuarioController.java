package br.com.itau.iti.usuario.controller;

import br.com.itau.iti.solicitacao.model.SolicitacaoSaida;
import br.com.itau.iti.usuario.facade.UsuarioFacade;
import br.com.itau.iti.usuario.model.UsuarioEntrada;
import br.com.itau.iti.usuario.model.UsuarioSaida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "iti/usuario", produces = "application/json")
@Configuration
@CrossOrigin
public class UsuarioController {

	@Autowired
	public UsuarioFacade usuarioFacade;


	@PostMapping
	public UsuarioSaida salvar( @RequestBody UsuarioEntrada usuarioEntrada) {

		UsuarioSaida saida = usuarioFacade.buscarUsuario(usuarioEntrada);
		return saida;
	}

	@PatchMapping("/{id}/alterarIdade")
	public UsuarioSaida alterarIdade(@PathVariable Long id, @RequestBody UsuarioEntrada usuarioEntrada) throws Exception {

		UsuarioSaida saida = usuarioFacade.alterarIdade(id,usuarioEntrada);

		return saida;
	}

	@GetMapping
	public List<UsuarioSaida> listarUsuarios() {

		List<UsuarioSaida> saida = usuarioFacade.listarUsuarios();

		return saida;
	}
}