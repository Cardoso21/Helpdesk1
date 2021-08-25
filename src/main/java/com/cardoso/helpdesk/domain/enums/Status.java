package com.cardoso.helpdesk.domain.enums;

public enum Status {
	
	ABERTO(0, "ABERTO"), ANDAMENTO(1,"ANDAMENTO"), ENCERRADO(2,"ENCERRADO");
	
	private Integer codigo;
	private String descriçao;
	
	private Status(Integer codigo, String descriçao) {
		this.codigo = codigo;
		this.descriçao = descriçao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescriçao() {
		return descriçao;
	}
	
	public static Status toEnum(Integer cod) {
		if (cod==null) {
			return null;
		}
		
		for(Status x : Status.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Perfil invalido");
	}
	
	
}
