package br.com.cadastro.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cadastro.cliente.Cliente;
import br.com.cadastro.fto.ClienteFTO;
import br.com.cadastro.model.Endereco;
import br.com.cadastro.model.Pessoa;
import br.com.cadastro.util.Converter;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Component
public class ClienteConverter implements Converter<Cliente, ClienteFTO, ClienteFTO>{

	private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
	private MapperFacade mapper = mapperFactory.getMapperFacade();

	@Autowired
	private EnderecoConverter enderecoConverter; 
	
	@Override
	public ClienteFTO convertForm(Cliente entity) {
		return mapper.map(entity, ClienteFTO.class);
	}

	@Override
	public ClienteFTO convertList(Cliente entity) {
		return mapper.map(entity, ClienteFTO.class);
	}

	@Override
	public Cliente convert(ClienteFTO fto) {
		Cliente cliente = new Cliente();
		
		List<Endereco> enderecos = new ArrayList<>();
		Endereco endereco = enderecoConverter.convert(fto.getEndereco());
		enderecos.add(endereco);
		
		cliente = mapper.map(fto, Cliente.class);
		endereco.setPessoa(cliente);
		cliente.setEnderecos(enderecos);
		return cliente;
	}
}
