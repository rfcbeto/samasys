package br.com.cadastro.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.fto.PessoaFTO;
import br.com.cadastro.model.Customer;

@Service
public class CustomerService {
	HashMap<String, Customer> custStorage = new HashMap<String, Customer>();
	
	@Autowired
	private PessoaService service;
	
	@PostConstruct
	void init(){
		Customer jack = new Customer("Jack", 20);
		Customer peter = new Customer("Peter", 30);
		custStorage.put("JACK", jack);
		custStorage.put("PETER", peter);
	}
	
	public Customer findCustomerByName(String name){
		return custStorage.get(name.toUpperCase());
	}

	public List<PessoaFTO> findAllCustomers() {
		List<PessoaFTO> lPessoaFTO = service.findAllFTO();
		return lPessoaFTO;
	}
}
