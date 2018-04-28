package br.com.cadastro.produto;

import javax.validation.constraints.NotNull;

public class ProdutoFTO {
	
	
	private String descricao;

	@NotNull
	private double valor;
	
	private String tipo;
	
	private String cor;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public String toString() {
		return "Produto [descricao=" + descricao 
				+ ", valor=" + valor 
				+ ", tipo=" + tipo 
				+ ", cor=" + cor + "]";
	}
}
