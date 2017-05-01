package entity;


public class Compra {

	private Pessoa pessoa;
	private Endereco endereco;
	private Produto produto;
	private String status;
	
	public Compra(Pessoa pessoa, Produto produto, String status) {
	this.pessoa = pessoa;
	this.produto = produto;
	this.status = status;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setListProduto(Produto produto) {
		this.produto = produto;
	}
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "Compra [pessoa=" + pessoa + ", endereco=" + endereco + ", produto=" + produto + "]";
	}
	
	
	
	
}
