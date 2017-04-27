package bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entity.Pessoa;
import entity.Produto;
import utils.Entrega;


@ManagedBean(name = "ctrlLoj")
@SessionScoped
public class Loja implements Serializable {

	private Pessoa pessoa;
	private List<Produto> listProduto;
	private Entrega entrega;
	private static final long serialVersionUID = 763273420141072853L;
	
	public Loja() {}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Produto> getListProduto() {
		return listProduto;
	}

	public void setListProduto(List<Produto> listProduto) {
		this.listProduto = listProduto;
	}

	public Entrega getEntrega() {
		return entrega;
	}

	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
	

}
