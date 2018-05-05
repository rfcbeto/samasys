package br.com.cadastro.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cadastro.cliente.Cliente;
import br.com.cadastro.fto.ClienteFTO;
import br.com.cadastro.model.Pessoa;
import br.com.cadastro.service.PessoaService;

@Controller
@RequestMapping(value="/cliente")
public class ClienteController {
	
	private static final Logger LOGGER = Logger.getLogger(ClienteController.class.getName());
	private static final String FORM = "pessoa/pessoa_form";
	private static final String LIST = "pessoa/pessoa_list";

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
		ModelAndView mv = new ModelAndView(FORM);
		
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
		
		pessoaService.insertCliente(fto);
		System.out.println(fto);
		LOGGER.info(">>> SALVAR CLIENTE");
		return mv;
	}
	
	@RequestMapping(value="/listar", method = RequestMethod.GET)
	public ModelAndView listarClientes(){
		LOGGER.info(">>>INICIO LISTAR CLIENTE");
		ModelAndView mv = new ModelAndView(LIST);
		
		List<Cliente> pessoas = pessoaService.findAllClientes();
		
		mv.addObject("pessoas", pessoas);
		LOGGER.info(">>>FIM LISTAR CLIENTE");
		return mv;
	}
	
	@RequestMapping(value="/get/{id}", method = RequestMethod.GET)
	public ModelAndView getById(@PathVariable("id") Long id){
		LOGGER.info(">>>INICIO LISTAR PESSOA");
		ModelAndView mv = new ModelAndView(LIST);
		
		List<Pessoa> pessoas = new ArrayList<>(); 
		pessoas.add(pessoaService.findOne(id));
		
		mv.addObject("pessoas", pessoas);
		LOGGER.info(">>>FIM LISTAR PESSOA");
		return mv;
	}
}
