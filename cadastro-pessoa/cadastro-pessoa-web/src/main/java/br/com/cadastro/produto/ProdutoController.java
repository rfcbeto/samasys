package br.com.cadastro.produto;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	private static final Logger LOGGER = Logger.getLogger(ProdutoController.class.getName());
	private static final String FORM = "produto/produto_form";
	
	@Autowired
	private ProdutoService service;
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
    public ModelAndView initVenda(Model model){
		ModelAndView view = new ModelAndView(FORM);
		LOGGER.info("Iniciando o cadastramento de produtos");
		model.addAttribute("fto", new ProdutoFTO());
		
    	return view;
    }

	@RequestMapping(value="/salvar", method = RequestMethod.GET)
	public ModelAndView cadastrarProduto (@Valid @ModelAttribute("fto") ProdutoFTO fto, BindingResult result, 
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
		
		
		Produto produto = service.insert(getProduto());
		System.out.println(fto);
		mv.addObject("fto", new ProdutoFTO());
		LOGGER.info("Produto: " + produto + " Cadastrado com sucesso!");
		return mv;
	}


	private Produto getProduto() {
		Produto produto = new Produto();
		
		produto.setCor("Black");
		produto.setDescricao("produto para modularização");
		produto.setTipo("TESTE");
		produto.setValor(45.00);
		
		return produto;
	}
}