package br.com.cayena.domain.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity<Product> implements Serializable {
	
	private static final long serialVersionUID = 4834836476094515932L;
	
	@Column(nullable = false)
	private String name;
	
	@Column(name = "stock_quantity", nullable = false)
	private Integer stockQuantity;
	
	@Column(name = "unit_price", nullable = false)
	private BigDecimal unitPrice;
	
	@ManyToOne
	@JoinColumn
	private Supplier supplier;

	@Override
	public void update(Product product) {
		this.name = product.getName();
		this.unitPrice = product.getUnitPrice();
		this.stockQuantity = product.getStockQuantity();
		this.supplier = product.getSupplier();
	}
	
	public Integer calculateStock(Integer quantity) {
		return quantity >= 0 ? this.stockQuantity + quantity : this.stockQuantity - Math.abs(quantity);
	}
}
