package br.com.cadastro;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.cadastro.cliente.Cliente;
import br.com.cadastro.model.Endereco;
import br.com.cadastro.repository.ClienteRepository;
import br.com.cadastro.repository.EnderecoRepository;

/*
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
*/

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClienteRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository endRepository;
	
	@Test
	public void inserirCliente() {
	    // given
		Cliente cliente =  new Cliente();
		cliente.setCelular("31999999998");
		cliente.setCpf("04786771727");
		cliente.setDataNascimento(new Date());
		cliente.setEstadoCivil("casado");
		cliente.setNaturalidade("Belo Horizonte");
		cliente.setNome("ROBERTO FRANÇA");
		cliente.setRg("11850646");
		cliente.setSexo("Masculino");
		cliente.setTelefone("9888888");
		cliente.setTipoCliente("Atacado");
		Endereco end = new Endereco();
		end.setBairro("Teixeira dias");
		end.setCep("0000000");
		end.setComplemento("asfa");
		end.setMunicipio("BH");
		end.setRua("Jose dos santos lage");
		end.setTipoEndereco(1);
		//end.setCliente(cliente);
		List<Endereco> lEndereco = new ArrayList<>();
		lEndereco.add(end);
		cliente.setEnderecos(lEndereco);
	    entityManager.persist(cliente);
	    entityManager.flush();
	 
	    // when
	    Endereco endereco = endRepository.findOne(1L);
	    
	    // then
	    assertEquals(1, endereco.getId());

	}
}
