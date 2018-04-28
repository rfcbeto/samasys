package br.com.cadastro.venda;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.cadastro.cliente.Cliente;
import br.com.cadastro.produto.Produto;

@Entity
@Table(name="VENDA")
public class Venda implements Serializable{
	private static final long serialVersionUID = 8788260394521051720L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	
	@Column(name="STATUS")
	private String status;

	/*A quantidade não sera necessário devido ao relacionamento
	 * com produto, a quantidade será calculada pela tabela de associação.
	 * */
	@Column(name="QUANTIDADE")
	private int quantidade;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="COD_CLIENTE", nullable=false, updatable=false)
	private Cliente cliente;

	@Column(name="TOTAL_VENDA")
	private double totalVenda;

	@Column(name="DATA_VENDA")
	private Calendar dataVenda;
	
	@Column(name="FORMA_PAGAMENTO")
	private String formaPagamento;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="PRODUTO_VENDA")
 	private List<Produto> produtos;
 	/*
		private Vendedor vendedor;
		private TipoVenda tipoVenda;
	*/
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
		return "Venda [id=" + id + 
				",\n status=" + status + 
				",\n quantidade=" + quantidade + 
				",\n cliente=" + cliente + 
				",\n totalVenda=" + totalVenda + 
				",\n dataVenda=" + dataVenda + 
				",\n formaPagamento=" + formaPagamento + 
				",\n produtos=" + produtos + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((dataVenda == null) ? 0 : dataVenda.hashCode());
		result = prime * result + ((formaPagamento == null) ? 0 : formaPagamento.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Venda other = (Venda) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
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
		if (id != other.id)
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
