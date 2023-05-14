package com.clinica.dto.enums;

public enum StatusConsulta {

	NAO_REALIZADA(0,"NÃO REALIZADA"),
	EM_ANDAMENTO(1,"EM ANDAMENTO"),
	REALIZADA(2,"REALIZADA"),
	CANCELADA(3,"CANCELADA");
	
	private int codigo;
    private String descricao;

    StatusConsulta(int codigo,String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

	public int getCodigo() {
		return codigo;
	}
	
}
