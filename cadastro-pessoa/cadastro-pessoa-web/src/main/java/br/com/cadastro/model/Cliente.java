package br.com.cadastro.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="CLIENTE")
public class Cliente extends Pessoa implements Serializable{

	private static final long serialVersionUID = -2821218991052026195L;

	@NotNull
	@Column(name="TIPO_CLIENTE")
	private String tipoCliente;
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Endereco> enderecos;
	
	/* Criar um gerenciador de recados.
	 * private List<Recado> recados; 
	 */


	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	@Override
	public String toString() {
		return "Cliente [tipoCliente=" + tipoCliente + ", enderecos=" + enderecos + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((enderecos == null) ? 0 : enderecos.hashCode());
		result = prime * result + ((tipoCliente == null) ? 0 : tipoCliente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (enderecos == null) {
			if (other.enderecos != null)
				return false;
		} else if (!enderecos.equals(other.enderecos))
			return false;
		if (tipoCliente == null) {
			if (other.tipoCliente != null)
				return false;
		} else if (!tipoCliente.equals(other.tipoCliente))
			return false;
		return true;
	}
}
