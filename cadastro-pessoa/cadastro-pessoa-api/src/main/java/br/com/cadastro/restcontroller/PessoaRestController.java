package br.com.cadastro.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaRestController {

	@RequestMapping(path="/api/pessoa")
	public String testarPessoa() {
		return "Teste Pessoa";
	}
}
