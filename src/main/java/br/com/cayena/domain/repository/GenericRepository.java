package br.com.cayena.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import br.com.cayena.domain.entities.BaseEntity;

@NoRepositoryBean
public interface GenericRepository<T extends BaseEntity<T>> extends JpaRepository<T, Long> {
	
	Optional<T> findByUuid(String uuid);
}
