package br.com.cadastro.venda;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

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

import br.com.cadastro.service.PessoaService;

@Controller
@RequestMapping("/venda")
public class VendaController {
	private static final Logger LOGGER = Logger.getLogger(VendaController.class.getName());
	private static final String FORM = "venda/venda_form";
	
	@Autowired
	private VendaService service;

	@Autowired
	private PessoaService pessoaService;
	
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
    public ModelAndView initVenda(Model model){
		ModelAndView view = new ModelAndView(FORM);
		LOGGER.info("Iniciando o cadastramento da venda");
		model.addAttribute("fto", new VendaFTO());
		
    	return view;
    }

	@RequestMapping(value="/salvar", method = RequestMethod.POST)
	public ModelAndView cadastrarPessoa (@Valid @ModelAttribute("fto") VendaFTO fto, BindingResult result, 
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
		
		Venda venda = service.insert(getVenda());
		mv.addObject("fto", new VendaFTO());
		LOGGER.info("Venda: " + venda.getId() + " Cadastrada com sucesso!");
		return mv;
	}

	private Venda getVenda() {
		Venda venda = new Venda();
		venda.setCliente(pessoaService.findOneCliente(1L));
		Locale local = new Locale("pt", "BR");
		venda.setDataVenda(Calendar.getInstance(local));
		venda.setStatus("Efetuado");
		venda.setTotalVenda(320.00);
		venda.setFormaPagamento("Dinheiro");
		
		return venda;
	}
}

