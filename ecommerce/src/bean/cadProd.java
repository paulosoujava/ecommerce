package bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.ProdutoDAO;
import entity.Produto;

@ManagedBean(name = "ctrlCadProd")
@RequestScoped
public class cadProd implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4833679231990142033L;
	
	private Produto produto = new Produto();
	private ProdutoDAO pDao = new ProdutoDAO();
	private String msg = "";
	
	
	public String inclur(){
		
		if( this.produto != null ){
			if( pDao.incluir(this.produto) > 0 ){
				produto = new Produto();
				this.msg = "Ebaa, produto incluido com sucesso.";
			}else{
				this.msg = "Opss, erro nosso, tente mais tarde.";
			}
		}else{
			this.msg = "Opss, dados em branco não são aceitos.";
		}
		return null;
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
