package entity;

public class Cidade {

	private Estado estado;
	private String cidade;
	
	
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	@Override
	public String toString() {
		return "Cidade [estado=" + estado + ", cidade=" + cidade + "]";
	}
	
	
}
