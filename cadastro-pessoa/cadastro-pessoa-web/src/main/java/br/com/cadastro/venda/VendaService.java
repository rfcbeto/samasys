package br.com.cadastro.venda;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.produto.Produto;
import br.com.cadastro.repository.ProdutoRepository;
import br.com.cadastro.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository repository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Venda insert(Venda venda){
		List<Produto> produtos = new ArrayList<>();
		
		Produto p1 = produtoRepository.findOne(1L);
		produtos.add(p1);
		Produto p2 = produtoRepository.findOne(2L);
		produtos.add(p2);
		Produto p3 = produtoRepository.findOne(3L);
		produtos.add(p3);
		Produto p4 = produtoRepository.findOne(4L);
		produtos.add(p4);
		Produto p5 = produtoRepository.findOne(5L);
		produtos.add(p5);
		
		venda.setProdutos(produtos);
		
		return repository.save(venda);
	} 
}
