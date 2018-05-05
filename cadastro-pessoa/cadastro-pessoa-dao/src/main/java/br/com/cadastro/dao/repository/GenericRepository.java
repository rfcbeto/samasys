package br.com.cadastro.dao.repository;

import java.io.Serializable;
import org.springframework.data.repository.Repository;

public interface GenericRepository<T, ID extends Serializable> extends Repository<T, ID>{

	<S extends T> S save(S entity);
	T findOne(ID id);
	Iterable<T> findAll();
	void delete(T entity);
	boolean exists(ID id);
}
