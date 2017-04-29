package bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.PromocaoDAO;
import entity.Produto;

@ManagedBean(name = "ctrlLisProm")
@RequestScoped
public class editProm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3971193493967079118L;
	/**
	 * 
	 */
	private PromocaoDAO pDAO = new PromocaoDAO();
	private Produto produto = new Produto();
	
	
	public List<Produto> getListPessoa() {
	
		return pDAO.obterProdutos();
	}
	
	public String editar(Produto produto) {
		this.produto = produto;
		System.out.println(produto);
		return "editProm.xhtml";
	}
	public String atualizar( ){
		pDAO.atualizar(this.produto);
			return "listProm.xhtml?faces-redirect=true";
		
	}
	public String deletar( ){
		
		if(pDAO.removerProduto(this.produto)  ){
			return "listProm.xhtml?faces-redirect=true";
		}else{
			return null;
		}
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
