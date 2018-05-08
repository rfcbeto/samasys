package br.com.cadastro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.converter.ClienteConverter;
import br.com.cadastro.converter.PessoaConverter;
import br.com.cadastro.fto.ClienteFTO;
import br.com.cadastro.fto.PessoaFTO;
import br.com.cadastro.model.Cliente;
import br.com.cadastro.model.Pessoa;
import br.com.cadastro.repository.ClienteRepository;
import br.com.cadastro.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaConverter converter;

	@Autowired
	private PessoaRepository repository;
	
	@Autowired
	private ClienteConverter clienteConverter;
	
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
	
	public List<PessoaFTO> findAllFTO(){
		List<Pessoa> pessoas = repository.findAll();
		List<PessoaFTO> lPessoaFto = new ArrayList<>();
		PessoaFTO fto;
		for (Pessoa p : pessoas) {
			fto = new PessoaFTO();
			BeanUtils.copyProperties(p, fto); 
			lPessoaFto.add(fto);
		}
		return lPessoaFto;
	}
	
	public Pessoa findOne(Long id) {
        return repository.findOne(id);
    }
	
	public Pessoa insert(PessoaFTO fto){
		/*Converter fto para Entidade*/
		Pessoa pessoa = converter.convert(fto);
		
		return repository.save(pessoa);
	}
	
	public Cliente findOneCliente(Long id){
		return clienteRepository.findOne(id);
	}
	
	public Cliente insertCliente(ClienteFTO fto){
		Cliente cliente = clienteConverter.convert(fto);
		
		return clienteRepository.save(cliente);
	}
	
	public Long totalPessoas(){
		Long total = clienteRepository.count();
		System.out.println("Total de que: " + total);
		return total;
	}

	public void findByTipoCliente(String tipoCliente) {
		List<Cliente> lCliente = clienteRepository.findByTipoCliente(tipoCliente);
		for (Cliente cliente : lCliente) {
			System.out.println(cliente.getNome() + ": " + cliente.getCpf());
		}
	}
}
