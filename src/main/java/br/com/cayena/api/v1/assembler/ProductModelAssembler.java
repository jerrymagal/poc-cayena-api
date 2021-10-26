package br.com.cayena.api.v1.assembler;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.cayena.api.v1.controller.ProductController;
import br.com.cayena.api.v1.model.ProductModel;
import br.com.cayena.api.v1.model.SupplierModel;
import br.com.cayena.api.v1.model.input.ProductInput;
import br.com.cayena.domain.entities.Product;
import br.com.cayena.domain.entities.Supplier;

@Component
public class ProductModelAssembler extends RepresentationModelAssemblerSupport<Product, ProductModel> {

	public ProductModelAssembler() {
		super(ProductController.class, ProductModel.class);
	}

	@Override
	public ProductModel toModel(Product product) {
		
		ProductModel model = createModelWithId(product.getUuid(), product);
		model.setUuid(product.getUuid());
		model.setName(product.getName());
		model.setStockQuantity(product.getStockQuantity());
		model.setUnitPrice(product.getUnitPrice());
		
		SupplierModel supplierModel = SupplierModel.builder().name(product.getSupplier().getName())
							   .uuid(product.getSupplier().getUuid()).build();
		
		model.setSupplier(supplierModel);
		
		return model;
	}
	
	public Product toEntity(ProductInput input) {
		Supplier supplier = new Supplier();
		supplier.setUuid(input.getSupplier().getUuid());
		
		return Product.builder().name(input.getName())
								.stockQuantity(input.getStockQuantity())
								.unitPrice(input.getUnitPrice())
								.supplier(supplier).build();
	}
}
