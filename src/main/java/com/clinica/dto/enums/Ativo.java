package com.clinica.dto.enums;

public enum Ativo {
	
	OFF(0,"OFF"),
	ATIVO(1,"ATIVO"),
	DESATIVADO(2,"DESATIVADO");
	
	private int codigo;
    private String descricao;

    Ativo(int codigo,String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

	public int getCodigo() {
		return codigo;
	}

}
