package br.com.cadastro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pessoa")
public class CadastroPessoaController {

	@RequestMapping(value="/get", method=RequestMethod.GET)
	public String get() {
		return "Solicitação GET.";	
	}
	
	@RequestMapping(path="/home", method=RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView view = new ModelAndView("index");
		
		return view;
	}
}
