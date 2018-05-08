package br.com.cadastro.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableWebMvc
@Configuration
@EntityScan("br.com.cadastro.model")
@ComponentScan("br.com.cadastro")
@EnableJpaRepositories("br.com.cadastro.repository")
@EnableAutoConfiguration
public class CadastroClienteApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CadastroClienteApplication.class);
	}
	
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(CadastroClienteApplication.class, args);
	}
	
	@Controller
	public class HomeController {
		@RequestMapping("/home")
		public ModelAndView home(Model model) {
			ModelAndView mv = new ModelAndView("index");
			return mv;
		}
		
		@RequestMapping("/map")
		public ModelAndView maps() {
			ModelAndView mv = new ModelAndView("map");
			return mv;
		}
	}	
}
