package br.com.cayena.api.v1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cayena.Constants;
import br.com.cayena.api.v1.assembler.ProductModelAssembler;
import br.com.cayena.api.v1.model.ProductModel;
import br.com.cayena.api.v1.model.input.ProductInput;
import br.com.cayena.domain.entities.Product;
import br.com.cayena.infrastructure.service.ProductService;

@RestController
@RequestMapping(path = Constants.CONTROLLER.PRODUCT.PATH)
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@Autowired
	private ProductModelAssembler assembler;
	
	@Autowired
	private PagedResourcesAssembler<Product> pagedResourcesAssembler;
	
	@GetMapping
	public PagedModel<ProductModel> list(@PageableDefault(size = 10) Pageable pageable) {
		Page<Product> page = service.getPage(pageable);
		return pagedResourcesAssembler.toModel(page, assembler);
	}
	
	@GetMapping("/{uuid}")
	public ProductModel getByUuid(@PathVariable String uuid) {
		return assembler.toModel(service.get(uuid));
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public ProductModel create(@RequestBody @Valid ProductInput productInput) {
		Product entity = service.create(assembler.toEntity(productInput));
		return assembler.toModel(entity);
	}
	
	@PutMapping("/{uuid}")
	public ProductModel update(@PathVariable String uuid, @RequestBody @Valid ProductInput productInput) {
		Product entity = service.update(uuid, assembler.toEntity(productInput));
		return assembler.toModel(entity);
	}
	
	@PutMapping("/{uuid}/stock-quantity")
	public ProductModel update(@PathVariable String uuid, @RequestParam("quantity") Integer quantity) {
		Product entity = service.updateQuantity(uuid, quantity);
		return assembler.toModel(entity);
	}
	
	@DeleteMapping("/{uuid}")
	public ResponseEntity<Void> update(@PathVariable String uuid) {
		service.delete(uuid);
		return ResponseEntity.ok().build();
	}
}
