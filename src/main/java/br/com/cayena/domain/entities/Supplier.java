package br.com.cayena.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Supplier extends BaseEntity<Supplier> implements Serializable {
	
	private static final long serialVersionUID = 4834836476094515932L;
	
	@Column
	private String name;

	@Override
	public void update(Supplier supplier) {
		this.name = supplier.getName();
	}
}
