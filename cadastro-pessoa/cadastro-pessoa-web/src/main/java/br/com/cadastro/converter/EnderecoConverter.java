package br.com.cadastro.converter;

import org.springframework.stereotype.Component;

import br.com.cadastro.fto.EnderecoFTO;
import br.com.cadastro.model.Endereco;
import br.com.cadastro.util.Converter;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Component
public class EnderecoConverter implements Converter<Endereco, EnderecoFTO, EnderecoFTO>{

	private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
	private MapperFacade mapper = mapperFactory.getMapperFacade();
	
	@Override
	public EnderecoFTO convertForm(Endereco entity) {
		return mapper.map(entity, EnderecoFTO.class);
	}

	@Override
	public EnderecoFTO convertList(Endereco entity) {
		return mapper.map(entity, EnderecoFTO.class);
	}

	@Override
	public Endereco convert(EnderecoFTO fto) {
		Endereco endereco = new Endereco();
		endereco = mapper.map(fto, Endereco.class);
		
		return endereco;
	}
}
