package br.com.cayena.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {
	
	DADOS_INVALIDOS("/dados-invalidos", "Dados inválidos"),
	RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado");
	
	private String title;
	private String uri;
	
	ProblemType(String path, String title) {
		this.uri = path;
		this.title = title;
	}
}
