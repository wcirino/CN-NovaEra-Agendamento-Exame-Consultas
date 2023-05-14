package com.clinica.dto.enums;

public enum Sexo {
	
		GENERO(0,"GENERO"),
		FEMININO(1,"FEMININO"),
		MASCULINO(2,"MASCULINO"),
		TRANS(3,"TRANS"),
		BISSEXUAL(4,"BISSEXUAL");
	

		private int codigo;
	    private String descricao;

	    Sexo(int codigo,String descricao) {
	        this.descricao = descricao;
	    }

	    public String getDescricao() {
	        return descricao;
	    }

		public int getCodigo() {
			return codigo;
		}

}
