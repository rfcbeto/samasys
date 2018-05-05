package br.com.cadastro.repository;

import org.springframework.stereotype.Repository;

import br.com.cadastro.dao.repository.GenericRepository;
import br.com.cadastro.venda.Venda;



@Repository
public interface VendaRepository extends GenericRepository<Venda, Long>{
	
	Long count();
}
