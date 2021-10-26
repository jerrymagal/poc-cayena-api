package br.com.cayena;

public interface Constants {
	
	interface CONTROLLER {
		
		String VERSION = "v1";
		String PATH_SEPARATOR = "/";
		
		interface PRODUCT {
			
			String NAME = "products";
			String PATH = PATH_SEPARATOR + VERSION + PATH_SEPARATOR + NAME;
		}
	}
	
	interface ERROR {
		String ENTITY_NOT_FOUND = "%s not found";
		String INVALID_FIELDS = "One or more fields are invalid. Fill in correctly and try again.";
		String STOCK_QUANTITY = "The amount of stock cannot be less than zero.";
	}
}
