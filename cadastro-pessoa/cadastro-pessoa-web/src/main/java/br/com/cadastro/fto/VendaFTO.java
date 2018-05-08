package br.com.cadastro.fto;

import java.util.Calendar;
import java.util.List;

import javax.validation.constraints.NotNull;

import br.com.cadastro.model.Pessoa;

public class VendaFTO {

	private Long id;
	@NotNull
	private double totalVenda;
	@NotNull
	private List<ProdutoFTO> produtos;
	private Pessoa pessoa;
	//private ClienteFTO clienteFTO;
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
