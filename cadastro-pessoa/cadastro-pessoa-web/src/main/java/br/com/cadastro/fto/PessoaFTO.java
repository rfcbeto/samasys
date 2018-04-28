package br.com.cadastro.fto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

public class PessoaFTO {


	@NotNull
	@Size(min=2,max=30)
	private String nome;
	private Date dataNascimento;
	@NotNull
	@CPF
	private String cpf;
	private String naturalidade;
	private String identidade;
	private EnderecoFTO endereco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dataNascimentoString = formatter.format(dataNascimento); 
        try {
            this.dataNascimento = formatter.parse(dataNascimentoString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public EnderecoFTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoFTO endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "PessoaFTO [nome=" + nome + ", dataNascimento=" + dataNascimento + ", cpf=" + cpf + ", naturalidade="
				+ naturalidade + ", identidade=" + identidade + ", endereco=" + endereco + "]";
	}
}
