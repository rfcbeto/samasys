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

import br.com.cadastro.fto.PessoaFTO;
import br.com.cadastro.model.Pessoa;
import br.com.cadastro.service.PessoaService;

@Controller
@RequestMapping(value="/pessoa")
public class PessoaController {
	
	private static final Logger LOGGER = Logger.getLogger(PessoaController.class.getName());
	private static final String FORM = "pessoa/pessoa_form";
	private static final String LIST = "pessoa/pessoa_list";

	@Autowired
	private PessoaService pessoaService;

	/*
	 @InitBinder
	 protected void initBinder(WebDataBinder binder) {
           binder.setValidator(new PessoaValidator());
	 }*/
	
	@RequestMapping(value="/form", method = RequestMethod.GET)
	public ModelAndView initPessoa(Model model){
		ModelAndView view = new ModelAndView(FORM);
		model.addAttribute("fto", new PessoaFTO());

		LOGGER.info("+++++CADASTRO INICIADO!+++++");
		return view;
	}
	
	@RequestMapping(value="/listar", method = RequestMethod.GET)
	public ModelAndView listarPessoas(){
		LOGGER.info(">>>INICIO LISTAR PESSOA");
		ModelAndView mv = new ModelAndView(LIST);
		
		List<Pessoa> pessoas = pessoaService.findAll();
		
		mv.addObject("pessoas", pessoas);
		LOGGER.info(">>>FIM LISTAR PESSOA");
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
	
	@RequestMapping(value="/salvar", method = RequestMethod.POST)
	public ModelAndView cadastrarPessoa (@Validated @ModelAttribute("fto") PessoaFTO fto, BindingResult result, 
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
		
		pessoaService.insert(fto);
		LOGGER.info(">>> SALVAR PESSOA");
		return mv;
	}
}
