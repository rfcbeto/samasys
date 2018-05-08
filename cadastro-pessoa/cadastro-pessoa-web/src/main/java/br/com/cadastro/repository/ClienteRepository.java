package br.com.cadastro.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cadastro.dao.repository.GenericRepository;
import br.com.cadastro.model.Cliente;

@Repository
public interface ClienteRepository extends GenericRepository<Cliente, Long>{
	
	Long count();
	/*
	 *Spring
	 *Recupera a Entidade utilizando como filtro a propriedade mapeada na classe.
	 *ex.: Na entidade Cliente tem a propriedade tipoCliente para fazer um pesquisa
	 *utilizando como parametro basta adicionar o prefixo "findBy" ao nome da propriedade camelcase
	 *findByTipoCliente 
	 * 
	 */
	List<Cliente> findByTipoCliente(String tipoCliente);
}
