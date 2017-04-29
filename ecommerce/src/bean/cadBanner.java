package bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.BannerDAO;
import dao.ProdutoDAO;
import entity.Banner;
import entity.Produto;

@ManagedBean(name = "ctrlCadBan")
@RequestScoped
public class cadBanner implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1323273430900757560L;
	private Banner banner = new Banner();
	private Produto p = new Produto();
	private BannerDAO pDao = new BannerDAO();
	private String msg = "";
	
	
	public String inclur(){
		
		if( this.p != null ){
			
			banner.setProduto(p);
			
			if( pDao.incluir(this.banner) > 0 ){
			
				banner = new Banner();
				p = new Produto();
				this.msg = "Ebaa, banner incluido com sucesso.";
			}else{
				this.msg = "Opss, erro nosso, tente mais tarde.";
			}
		}else{
			this.msg = "Opss, dados em branco não são aceitos.";
		}
		return null;
	}
	
	public Banner getBanner() {
		return banner;
	}
	public void setBanner(Banner produto) {
		this.banner = produto;
	}

	public Produto getP() {
		return p;
	}

	public void setP(Produto p) {
		this.p = p;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
