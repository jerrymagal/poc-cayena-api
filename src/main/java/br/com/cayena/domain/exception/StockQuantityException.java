package br.com.cayena.domain.exception;

import br.com.cayena.Constants;

public class StockQuantityException extends RuntimeException {
	
	private static final long serialVersionUID = 811213575478204097L;

	public StockQuantityException() {
		super(Constants.ERROR.STOCK_QUANTITY);
	}
}
