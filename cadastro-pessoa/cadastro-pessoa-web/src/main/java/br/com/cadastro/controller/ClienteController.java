package br.com.cadastro.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cadastro.cliente.Cliente;
import br.com.cadastro.fto.ClienteFTO;
import br.com.cadastro.model.Endereco;
import br.com.cadastro.service.PessoaService;

@Controller
@RequestMapping(value="/cliente")
public class ClienteController {
	
	private static final Logger LOGGER = Logger.getLogger(ClienteController.class.getName());
	private static final String FORM = "pessoa/pessoa_form";

	@Autowired
	private PessoaService pessoaService;

	@RequestMapping(value="/form", method = RequestMethod.GET)
	public ModelAndView initPessoa(Model model){
		ModelAndView view = new ModelAndView(FORM);
		model.addAttribute("fto", new ClienteFTO());

		LOGGER.info("+++++CADASTRO INICIADO!+++++");
		return view;
	}
	
	@RequestMapping(value="/salvar", method = RequestMethod.POST)
	public ModelAndView cadastrarCliente (@Validated @ModelAttribute("fto") ClienteFTO fto, BindingResult result, 
			HttpServletResponse response, RedirectAttributes redirectAttibutes){
		ModelAndView mv = new ModelAndView("sucesso");
		
		if(result.hasErrors()){
			mv = new ModelAndView(FORM);
			String errorMessage = "";
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			List<ObjectError> errors = result.getAllErrors();
			for( ObjectError e : errors){
  				errorMessage += "ERROR: " + e.getDefaultMessage()+"\n";
  			}
			
			LOGGER.info(">>> Tipo que deu merda:\n-"+errorMessage);
			return mv;
		}
		
		pessoaService.insertCliente(getCliente());
		System.out.println(fto);
		LOGGER.info(">>> SALVAR PESSOA");
		return mv;
	}

	public Cliente getCliente() {
		
		Cliente p = new Cliente();
		p.setNome("Jose");
		p.setCpf("12345678910");
		p.setEstadoCivil("solteiro");
		p.setRg("123456789");
		p.setSexo("Masculino");
		p.setTipoCliente("varejo");
		p.setCelular("977777777");
		p.setTelefone("31988888888");
		p.setDataNascimento(new Date());
		
		List<Endereco> lEndereco = new ArrayList<>();
		Endereco end1 = new Endereco();
		end1.setPessoa(p);
		end1.setBairro("Centro");
		end1.setCep("12345678");
		end1.setComplemento("Apt 555");
		end1.setMunicipio("Centro");
		end1.setNumero(123);
		end1.setRua("RUA teste cadastro");
		lEndereco.add(end1);
		
		p.setEnderecos(lEndereco);
		return p;
	}
}
