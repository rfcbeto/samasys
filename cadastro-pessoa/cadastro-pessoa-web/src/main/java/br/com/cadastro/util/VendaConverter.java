package br.com.cadastro.util;

import org.springframework.stereotype.Component;

import br.com.cadastro.venda.Venda;
import br.com.cadastro.venda.VendaFTO;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Component
public class VendaConverter implements Converter<Venda, VendaFTO, VendaFTO>{

	private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
	private MapperFacade mapper = mapperFactory.getMapperFacade();
	
	@Override
	public VendaFTO convertForm(Venda venda) {
		return mapper.map(venda, VendaFTO.class);
	}

	@Override
	public VendaFTO convertList(Venda venda) {
		return mapper.map(venda, VendaFTO.class);
	}

	@Override
	public Venda convert(VendaFTO vendaDto) {
		return mapper.map(vendaDto, Venda.class);
	}
}
