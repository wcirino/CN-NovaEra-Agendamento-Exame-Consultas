package com.clinica.dto.enums;

public enum SexoPrestador {

	GENERO(0,"GENERO"),
	MASCULINO(2,"MASCULINO"),
	FEMININO(1,"FEMININO"),
	TRANS(3,"TRANS"),
	BISSEXUAL(4,"BISSEXUAL");

	private int codigo;
    private String descricao;

    SexoPrestador(int codigo,String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

	public int getCodigo() {
		return codigo;
	}
	
}
