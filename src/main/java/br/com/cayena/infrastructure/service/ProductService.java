package br.com.cayena.infrastructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cayena.domain.entities.Product;
import br.com.cayena.domain.entities.Supplier;
import br.com.cayena.domain.exception.StockQuantityException;
import br.com.cayena.domain.repository.ProductRepository;

@Service
public class ProductService extends GenericServiceImpl<Product> {
	
	@Autowired
	private SupplierService supplierService;

	@Autowired
	public ProductService(ProductRepository repository) {
		super(repository);
	}

	@Override
	public Product create(Product entity) {
		Supplier supplier = supplierService.get(entity.getSupplier().getUuid());
		entity.setSupplier(supplier);
		return super.create(entity);
	}

	@Override
	public Product update(String uuid, Product entity) {
		Supplier supplier = supplierService.get(entity.getSupplier().getUuid());
		entity.setSupplier(supplier);
		return super.update(uuid, entity);
	}
	
	public Product updateQuantity(String uuid, Integer quantity) {
		
		Product product = get(uuid);
		Integer newQuantity = product.calculateStock(quantity);
		
		if(newQuantity < 0) {
			throw new StockQuantityException();
		}
		
		product.setStockQuantity(newQuantity);
		
		return super.update(product);
	}
}
