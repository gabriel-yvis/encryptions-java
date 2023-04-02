package model;

public class Cesar {
	private String criptografado, descriptografado;
	private int chave;

	public String getCriptografado() {
		return criptografado;
	}

	public void setCriptografado(String criptografado) {
		this.criptografado = criptografado;
	}

	public String getDescriptografado() {
		return descriptografado;
	}

	public void setDescriptografado(String descriptografado) {
		this.descriptografado = descriptografado;
	}
	
	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}
}
