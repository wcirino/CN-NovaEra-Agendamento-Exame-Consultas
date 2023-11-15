package com.clinica.dto.enums;

public enum StatusConsulta {

	NAO_REALIZADA("N","NÃO REALIZADA"),
	EM_ANDAMENTO("E","EM ANDAMENTO"),
	REALIZADA("S","REALIZADA"),
	CANCELADA("C","CANCELADA");
	
	private String codigo;
    private String descricao;

    StatusConsulta(String codigo,String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

	public String getCodigo() {
		return codigo;
	}
	
}
