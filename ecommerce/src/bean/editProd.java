package bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.ProdutoDAO;
import entity.Produto;

@ManagedBean(name = "ctrlLisProd")
@RequestScoped
public class editProd implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7721624299799254899L;
	private ProdutoDAO pDAO = new ProdutoDAO();
	private Produto produto = new Produto();
	
	
	public List<Produto> getListPessoa() {
	
		return pDAO.obterProdutos();
	}
	
	public String editar(Produto produto) {
		this.produto = produto;
		System.out.println(produto);
		return "editProd.xhtml";
	}
	public String atualizar( ){
		pDAO.atualizar(this.produto);
			return "listProd.xhtml?faces-redirect=true";
		
	}
	public String deletar( ){
		
		if(pDAO.removerProduto(this.produto)  ){
			return "listProd.xhtml?faces-redirect=true";
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
