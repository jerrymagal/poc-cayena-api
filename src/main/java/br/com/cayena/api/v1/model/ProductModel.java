package br.com.cayena.api.v1.model;

import java.math.BigDecimal;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductModel extends RepresentationModel<ProductModel> {
	
	private String uuid;
	private String name;
	private Integer stockQuantity;
	private BigDecimal unitPrice;
	private SupplierModel supplier;
}
