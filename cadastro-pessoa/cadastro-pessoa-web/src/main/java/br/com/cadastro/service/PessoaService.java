package br.com.cadastro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.cliente.Cliente;
import br.com.cadastro.fto.PessoaFTO;
import br.com.cadastro.model.Endereco;
import br.com.cadastro.model.Pessoa;
import br.com.cadastro.repository.ClienteRepository;
import br.com.cadastro.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public List<Pessoa> findAll(){
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas = repository.findAll();
		PessoaFTO fto = new PessoaFTO();
		
		for (Pessoa p : pessoas) {
			System.out.println("Entidade: " + p.getNome());
			System.out.println("--------------------------------------");
			BeanUtils.copyProperties(p, fto); 
			System.out.println("Objeto: "+fto);
		}
		
		return pessoas;
	}
	
	public Pessoa findOne(Long id) {
        return repository.findOne(id);
    }
	
	public Pessoa insert(Pessoa pessoa){
		return repository.save(pessoa);
	}
	
	public Cliente findOneCliente(Long id){
		return clienteRepository.findOne(id);
	};
	
	public Cliente insertCliente(Cliente cliente){
		return clienteRepository.save(cliente);
	}
	
	public Pessoa getPessoa() {
		Pessoa p = new Pessoa();
		p.setNome("Etelvino da silva");
		p.setCpf("12345678910");
		p.setEstadoCivil("solteiro");
		p.setRg("123456789");
		p.setSexo("Feminino");
		
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
