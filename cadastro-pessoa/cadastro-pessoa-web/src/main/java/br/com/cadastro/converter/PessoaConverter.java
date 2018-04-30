package br.com.cadastro.converter;

import org.springframework.stereotype.Component;

import br.com.cadastro.fto.PessoaFTO;
import br.com.cadastro.model.Pessoa;
import br.com.cadastro.util.Converter;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Component
public class PessoaConverter implements Converter<Pessoa, PessoaFTO, PessoaFTO>{

	private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
	private MapperFacade mapper = mapperFactory.getMapperFacade();
	
	@Override
	public PessoaFTO convertForm(Pessoa entity) {
		return mapper.map(entity, PessoaFTO.class);
	}

	@Override
	public PessoaFTO convertList(Pessoa entity) {
		return mapper.map(entity, PessoaFTO.class);
	}

	@Override
	public Pessoa convert(PessoaFTO fto) {
		Pessoa pessoa = new Pessoa();
		pessoa = mapper.map(fto, Pessoa.class);
		
		return pessoa;
	}

}
