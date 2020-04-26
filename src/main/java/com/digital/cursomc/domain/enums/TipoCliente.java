package com.digital.cursomc.domain.enums;

public enum TipoCliente {
	
	PESSOAFISICA(1, "Pessoa Física"), 
	PESSOAJURIDICA(2, "Pessoa Jurídica");

	private int cod;
	private String descricao;

	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoCliente toEnum(Integer id) {
		if (id == null) {
			return null;
		}
		for (TipoCliente x : TipoCliente.values()) {
			if (id.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido " + id);
	}

	public static String getById(int id) {
		for (TipoCliente e : values()) {
			if (e.getCod() == (id))
				return e.getDescricao();
		}
		return null;
	}

	public static int findById(String s) {
		for (TipoCliente e : values()) {
			if (e.getDescricao().equals(s))
				return e.getCod();
		}
		return -1;
	}
	
}
