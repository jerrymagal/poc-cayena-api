package br.com.cayena.infrastructure.service;

import java.lang.reflect.ParameterizedType;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.cayena.domain.entities.BaseEntity;
import br.com.cayena.domain.exception.EntityNotFoundException;
import br.com.cayena.domain.repository.GenericRepository;
import br.com.cayena.domain.service.GenericService;

public abstract class GenericServiceImpl<T extends BaseEntity<T>> implements GenericService<T> {
	
	private final GenericRepository<T> repository;
	
	public GenericServiceImpl(GenericRepository<T> repository) {
        this.repository = repository;
    }

	@Override
	public Page<T> getPage(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public T get(String uuid) {
		return repository.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException(getGenericName()));
	}

	@Override
	public T update(String uuid, T entity) {
		T domain = get(uuid);
		domain.update(entity);
		return update(domain);
	}
	
	@Override
	public T update(T entity) {
		entity.setDateUpdate(LocalDateTime.now());
		return repository.save(entity);
	}

	@Override
	public T create(T entity) {
		entity.setUuid(UUID.randomUUID().toString());
		entity.setDateInsert(LocalDateTime.now());
		return repository.save(entity);
	}

	@Override
	public void delete(String uuid) {
		T t = get(uuid);
		repository.delete(t);
	}
	
	@SuppressWarnings("unchecked")
	protected String getGenericName() {
        return ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
    } 
}
