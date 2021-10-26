package br.com.cayena.domain.exception;

import br.com.cayena.Constants;

public class EntityNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 8302471380728724737L;

	public EntityNotFoundException(String message) {
		super(String.format(Constants.ERROR.ENTITY_NOT_FOUND, message));
	}
}
