package br.com.cadastro.fto;

/**
 * @author roberto.coelho
 *
 */

public class EnderecoFTO{
	
	
	private String cep;
	private String rua;
	private int numero;
	private String bairro;
	private String municipio;
	private int tipoEndereco;
	private String complemento;

	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public int getTipoEndereco() {
		return tipoEndereco;
	}
	public void setTipoEndereco(int tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	@Override
	public String toString() {
		return "EnderecoFTO [cep=" + cep + ", rua=" + rua + ", numero=" + numero + ", bairro=" + bairro + ", municipio="
				+ municipio + ", tipoEndereco=" + tipoEndereco + ", complemento=" + complemento + "]";
	}
}	