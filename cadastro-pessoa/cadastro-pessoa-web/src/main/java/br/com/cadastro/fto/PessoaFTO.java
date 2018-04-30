package br.com.cadastro.fto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

public class PessoaFTO {


	@NotNull
	@Size(min=2,max=30)
	private String nome;
	@NotNull
	@CPF
	private String cpf;
	private String rg;
	private String sexo;
	private String celular;
	private String telefone;
	private String estadoCivil;
	private Date dataNascimento;
	private String naturalidade;
	private EnderecoFTO endereco;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getNaturalidade() {
		return naturalidade;
	}
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	public EnderecoFTO getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoFTO endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "PessoaFTO [nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", sexo=" + sexo + ", celular=" + celular
				+ ", telefone=" + telefone + ", estadoCivil=" + estadoCivil + ", dataNascimento=" + dataNascimento
				+ ", naturalidade=" + naturalidade + ", endereco=" + endereco + "]";
	}
	
}
