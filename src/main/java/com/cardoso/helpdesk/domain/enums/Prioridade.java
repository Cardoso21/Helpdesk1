package com.cardoso.helpdesk.domain.enums;

public enum Prioridade {
	
	BAIXA(0, "BAIXA"), MEDIA(1,"MEDIA"), ALTA(2,"ALTA");
	
	private Integer codigo;
	private String descriçao;
	
	private Prioridade(Integer codigo, String descriçao) {
		this.codigo = codigo;
		this.descriçao = descriçao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescriçao() {
		return descriçao;
	}
	
	public static Prioridade toEnum(Prioridade cod) {
		if (cod==null) {
			return null;
		}
		
		for(Prioridade x : Prioridade.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Prioridade invalida");
	}
	
	
}
