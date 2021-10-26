package br.com.cayena.domain.repository;

import org.springframework.stereotype.Repository;

import br.com.cayena.domain.entities.Product;

@Repository
public interface ProductRepository extends GenericRepository<Product> {
}
