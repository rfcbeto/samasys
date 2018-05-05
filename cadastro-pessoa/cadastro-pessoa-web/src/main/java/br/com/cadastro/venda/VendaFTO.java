package br.com.cadastro.venda;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import br.com.cadastro.cliente.Cliente;
import br.com.cadastro.fto.ClienteFTO;
import br.com.cadastro.model.Pessoa;
import br.com.cadastro.produto.Produto;
import br.com.cadastro.produto.ProdutoFTO;

public class VendaFTO {

	private Long id;
	@NotNull
	private double totalVenda;
	@NotNull
	private List<ProdutoFTO> produtos;
	private Pessoa pessoa;
	private ClienteFTO clienteFTO;
	private String formaPagamento;
	private String status;
	private Calendar dataVenda;
	/*
	 * private Vendedor vendedor; private TipoVenda tipoVenda;
	 */

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ProdutoFTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoFTO> produtos) {
		this.produtos = produtos;
	}

	public double getTotalVenda() {
		return totalVenda;
	}

	public void setTotalVenda(double totalVenda) {
		this.totalVenda = totalVenda;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Calendar getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Calendar dataVenda) {
		this.dataVenda = dataVenda;
	}

	@Override
	public String toString() {
		return "VendaFTO [id=" + id + ", totalVenda=" + totalVenda + ", produtos=" + produtos + ", pessoa=" + pessoa
				+ ", formaPagamento=" + formaPagamento + ", status=" + status
				+ ", dataVenda=" + dataVenda + "]";
	}
}
