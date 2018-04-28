package br.com.cadastro.util;

public interface Converter<ENTITY, FTO, LTO> {
	
	 	public abstract FTO convertForm(ENTITY entity);
	    public abstract LTO convertList(ENTITY entity);
	    
	    public default <STO> LTO convertList(ENTITY entity, STO sto) {
	        return convertList(entity);
	    }
	    public abstract ENTITY convert(FTO entity);
}
