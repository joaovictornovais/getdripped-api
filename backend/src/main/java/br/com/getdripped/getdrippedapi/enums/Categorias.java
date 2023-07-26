package br.com.getdripped.getdrippedapi.enums;

public enum Categorias {

	CAMISETA(1),
	JAQUETA(2), 
	CALÇA(3), 
	SHORT(4), 
	BONE(5);
	
	private int code;
	
	private Categorias(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Categorias valueOf(int code) {
		for (Categorias value : Categorias.values()) {
			if (value.getCode() == code) return value;
		}
		throw new IllegalArgumentException("Código de Categoria inválido.");
	}
	
}
