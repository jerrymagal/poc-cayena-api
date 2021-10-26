package br.com.cayena.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.cayena.domain.entities.BaseEntity;

public interface GenericService<T extends BaseEntity<T>> {
	
	Page<T> getPage(Pageable pageable);
	
	T get(String uuid);
	
	T update(String uuid, T entity);
	
	T update(T entity);
	
	T create(T entity);
	
	void delete(String uuid);
}
