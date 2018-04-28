package br.com.cadastro.venda;

import java.util.Calendar;
import java.util.List;

import javax.validation.constraints.NotNull;

import br.com.cadastro.model.Pessoa;
import br.com.cadastro.produto.ProdutoFTO;

public class VendaFTO {

	private Long id; 
	
	@NotNull
	private double totalVenda;
 	
	@NotNull
	private List<ProdutoFTO> produtos;
	
	private Pessoa pessoa;
	
	 	/*	
		private Vendedor vendedor;
	
		private Cliente cliente;
	
		private TipoVenda tipoVenda;
	*/
	
	
	private int quantidade;
	
	private String formaPagamento;
	
	private String status;
	
	private Calendar dataVenda;

	
	
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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
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
				+ ", quantidade=" + quantidade + ", formaPagamento=" + formaPagamento + ", status=" + status
				+ ", dataVenda=" + dataVenda + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataVenda == null) ? 0 : dataVenda.hashCode());
		result = prime * result + ((formaPagamento == null) ? 0 : formaPagamento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((produtos == null) ? 0 : produtos.hashCode());
		result = prime * result + quantidade;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalVenda);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VendaFTO other = (VendaFTO) obj;
		if (dataVenda == null) {
			if (other.dataVenda != null)
				return false;
		} else if (!dataVenda.equals(other.dataVenda))
			return false;
		if (formaPagamento == null) {
			if (other.formaPagamento != null)
				return false;
		} else if (!formaPagamento.equals(other.formaPagamento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (produtos == null) {
			if (other.produtos != null)
				return false;
		} else if (!produtos.equals(other.produtos))
			return false;
		if (quantidade != other.quantidade)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (Double.doubleToLongBits(totalVenda) != Double.doubleToLongBits(other.totalVenda))
			return false;
		return true;
	}
	
	
}
