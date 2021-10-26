package br.com.cayena.api.v1.model.input;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.cayena.api.v1.model.SupplierModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductInput {
	
	@NotBlank
	private String name;
	
	@NotNull
	private Integer stockQuantity;
	
	@NotNull
	private BigDecimal unitPrice;
	
	@NotNull
	private SupplierModel supplier;
}
