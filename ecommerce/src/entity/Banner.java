package entity;

public class Banner {
	
	private String imgBannerPrin;
	private Produto produto;
	private Integer idBanner;
	public String getImgBannerPrin() {
		return imgBannerPrin;
	}
	public void setImgBannerPrin(String imgBannerPrin) {
		this.imgBannerPrin = imgBannerPrin;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Integer getIdBanner() {
		return idBanner;
	}
	public void setIdBanner(Integer idBanner) {
		this.idBanner = idBanner;
	}
	@Override
	public String toString() {
		return "Banner [imgBannerPrin=" + imgBannerPrin + ", produto=" + produto + ", idBanner=" + idBanner + "]";
	}
	
	

}
