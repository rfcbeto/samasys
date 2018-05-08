package br.com.cadastro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.model.Produto;
import br.com.cadastro.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	public Produto insert(Produto produto){
		return repository.save(produto);
	} 
}
