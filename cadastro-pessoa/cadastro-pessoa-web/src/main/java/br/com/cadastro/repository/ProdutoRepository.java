package br.com.cadastro.repository;

import org.springframework.stereotype.Repository;

import br.com.cadastro.dao.repository.GenericRepository;
import br.com.cadastro.produto.Produto;



@Repository
public interface ProdutoRepository extends GenericRepository<Produto, Long>{
	
	Long count();
}
