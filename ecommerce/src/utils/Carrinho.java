package utils;

import java.util.List;

import entity.Pessoa;
import entity.Produto;

public class Carrinho {
	
	private Pessoa pessoa;
	private List<Produto> list_Produtos;
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public List<Produto> getList_Produtos() {
		return list_Produtos;
	}
	public void setList_Produtos(List<Produto> list_Produtos) {
		this.list_Produtos = list_Produtos;
	}

	
	
}
