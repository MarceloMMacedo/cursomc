package com.digital.cursomc.domain.enums;

public enum EstadoPagamento {
	
	PENEDETE(1, "Pendente"), 
	QUITADO(2, "Quitado"),
	CANCELADO(3, "CANCELADO");

	private int cod;
	private String descricao;

	private EstadoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EstadoPagamento toEnum(Integer id) {
		if (id == null) {
			return null;
		}
		for (EstadoPagamento x : EstadoPagamento.values()) {
			if (id.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido " + id);
	}

	public static String getById(int id) {
		for (EstadoPagamento e : values()) {
			if (e.getCod() == (id))
				return e.getDescricao();
		}
		return null;
	}

	public static int findById(String s) {
		for (EstadoPagamento e : values()) {
			if (e.getDescricao().equals(s))
				return e.getCod();
		}
		return -1;
	}
	
}
