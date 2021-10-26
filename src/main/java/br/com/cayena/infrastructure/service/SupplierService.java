package br.com.cayena.infrastructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cayena.domain.entities.Supplier;
import br.com.cayena.domain.repository.SupplierRepository;

@Service
public class SupplierService extends GenericServiceImpl<Supplier> {

	@Autowired
	public SupplierService(SupplierRepository repository) {
		super(repository);
	}
}
