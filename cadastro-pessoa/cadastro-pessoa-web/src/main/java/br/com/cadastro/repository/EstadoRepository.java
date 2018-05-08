package br.com.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastro.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{
	
}
