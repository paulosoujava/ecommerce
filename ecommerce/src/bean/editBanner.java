package bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.BannerDAO;
import entity.Banner;
import entity.Produto;

@ManagedBean(name = "ctrlLisBann")
@RequestScoped
public class editBanner implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5897797572939172971L;
	private BannerDAO pDAO = new BannerDAO();
	private Banner banner = new Banner();
	private Produto p = new Produto();
	
	public List<Banner> getListPessoa() {
	
		return pDAO.obterProdutos();
	}
	
	public String editar(Banner produto) {
		
		System.err.println("------------------ EDITAR BANNER -----------------");
		System.out.println(this.banner);
		System.err.println("------------------ EDITAR BANNER -----------------");
		
		
		this.banner = produto;
		this.p.setNome( this.banner.getProduto().getNome() );
		this.p.setDesc( this.banner.getProduto().getDesc() );
		this.p.setEstoque( this.banner.getProduto().getEstoque() );
		this.p.setImg1( this.banner.getProduto().getImg1() );
		this.p.setImg2( this.banner.getProduto().getImg2() );
		this.p.setImg3( this.banner.getProduto().getImg3());
		this.p.setValor( this.banner.getProduto().getValor());
		
	
		return "editBanner.xhtml";
	}
	public String atualizar( ){
		
		this.banner.setProduto(this.p);
		
		pDAO.atualizar(this.banner);
			return "listBanner.xhtml?faces-redirect=true";
		
	}
	public String deletar( ){
		
		if(pDAO.removerProduto(this.banner)  ){
			return "listBanner.xhtml?faces-redirect=true";
		}else{
			return null;
		}
	}

	public Banner getProduto() {
		return banner;
	}

	public void setProduto(Banner produto) {
		this.banner = produto;
	}

	public Produto getP() {
		return p;
	}

	public void setP(Produto p) {
		this.p = p;
	}

}
