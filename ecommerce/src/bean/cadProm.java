package bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.ProdutoDAO;
import dao.PromocaoDAO;
import entity.Produto;
@ManagedBean(name = "ctrlCadProm")
@RequestScoped
public class cadProm  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3349003046036951554L;
	private Produto produto = new Produto();
	private PromocaoDAO pDao = new PromocaoDAO();
	private String msg = "";
	
	
	public String inclur(){
		
		if( this.produto != null ){
			if( pDao.incluir(this.produto) > 0 ){
				produto = new Produto();
				this.msg = "Ebaa, promocao incluida com sucesso.";
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
	public int qtdProm(){
		PromocaoDAO p = new PromocaoDAO();
		return p.obterProdutos().size();
	}
	

}
