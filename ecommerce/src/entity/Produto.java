package entity;

public class Produto {
	
	private Integer idProduto;
	private String tipoDeProduto;
	private String nome;
	private String desc;
	private Float valor;
	
	
	
	public Integer getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}
		
	public String getTipoDeProduto() {
		return tipoDeProduto;
	}
	public void setTipoDeProduto(String tipoDeProduto) {
		this.tipoDeProduto = tipoDeProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", nome=" + nome + ", desc=" + desc + ", valor=" + valor + "]";
	}
	
	
	

}
