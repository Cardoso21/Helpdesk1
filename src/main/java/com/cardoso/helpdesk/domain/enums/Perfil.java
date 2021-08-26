package com.cardoso.helpdesk.domain.enums;

public enum Perfil {
	
	ADMIN(0, "ROLE_ADMIN"), CLIENTE(1,"ROLE_CLIENTE"), TECNICO(2,"ROLE_TECNICO");
	
	private Integer codigo;
	private String descriçao;
	
	private Perfil(Integer codigo, String descriçao) {
		this.codigo = codigo;
		this.descriçao = descriçao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescriçao() {
		return descriçao;
	}
	
	public static Perfil toEnum(Integer cod) {
		if (cod==null) {
			return null;
		}
		
		for(Perfil x : Perfil.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Perfil invalido");
	}
	
	
}
