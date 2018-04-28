package br.com.cadastro.cliente;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.cadastro.model.Pessoa;

@Entity
@Table(name="CLIENTE")
public class Cliente extends Pessoa implements Serializable{

	private static final long serialVersionUID = -2821218991052026195L;

	@Id
	@Column(name = "ID_CLIENTE")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Column(name="TIPO_CLIENTE")
	private String tipoCliente;
	
	/* Criar um gerenciador de recados.
	 * private List<Recado> recados; 
	 */
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + 
				",\n tipoCliente=" + tipoCliente + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (id ^ (id >>> 32));
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
		if (id != other.id)
			return false;
		if (tipoCliente == null) {
			if (other.tipoCliente != null)
				return false;
		} else if (!tipoCliente.equals(other.tipoCliente))
			return false;
		return true;
	}
}
