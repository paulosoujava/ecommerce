package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.BannerDAO;
import dao.ProdutoDAO;
import dao.PromocaoDAO;
import dao.VideoDAO;
import entity.Banner;
import entity.Produto;
import entity.Video;


@ManagedBean(name = "carBean")
@SessionScoped
public class Carrinho  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2638169811790410644L;
    private Produto produto = new Produto();
	
	//SLAIDS -- 4
	private Banner slaid_um;
	private Banner slaid_dois;
	private Banner slaid_tres;
	private Banner slaid_quatro;
	private Banner slaid_default;
	
	//PROMOCOES -- 7
	private Produto promocao1;
	private Produto promocao2;
	private Produto promocao3;
	private Produto promocao4;
	private Produto promocao5;
	private Produto promocao6;
	private Produto promocao7;
	
	//VIDEO - 2
	private Video video1;
	private Video video2;
	
	//CARRINHO
	private List<Object>listCarrinho = new ArrayList<>();
	private List<Produto> listProdutDoCarrinho = new ArrayList<>();
	
	public Carrinho(){
		BannerDAO b = new BannerDAO();
		PromocaoDAO pr = new PromocaoDAO();
		VideoDAO v = new VideoDAO();
		//init slaid
		int sizeB = b.obterProdutos().size();
		switch (sizeB) {
		case 4:
			 this.slaid_um     = ( !(b.obterProdutos().get(0)).equals("")?  b.obterProdutos().get(0): this.getSlaid_default());
			 this.slaid_dois   = ( !(b.obterProdutos().get(1)).equals("")?  b.obterProdutos().get(1): this.getSlaid_default());
			 this.slaid_tres   = ( !(b.obterProdutos().get(2)).equals("")?  b.obterProdutos().get(2): this.getSlaid_default());
			 this.slaid_quatro   = ( !(b.obterProdutos().get(3)).equals("")?  b.obterProdutos().get(3): this.getSlaid_default());
			 
			break;
		case 3:
			 this.slaid_um     = ( !(b.obterProdutos().get(0)).equals("")?  b.obterProdutos().get(0): this.getSlaid_default());
			 this.slaid_dois   = ( !(b.obterProdutos().get(1)).equals("")?  b.obterProdutos().get(1): this.getSlaid_default());
			 this.slaid_tres   = ( !(b.obterProdutos().get(2)).equals("")?  b.obterProdutos().get(2): this.getSlaid_default());
			 this.slaid_quatro = (  this.getSlaid_default());
			 
					break;
		case 2:
			 this.slaid_um     = ( !(b.obterProdutos().get(0)).equals("")?  b.obterProdutos().get(0): this.getSlaid_default());
			 this.slaid_dois   = ( !(b.obterProdutos().get(1)).equals("")?  b.obterProdutos().get(1): this.getSlaid_default());
			 this.slaid_tres   = ( this.getSlaid_default());
			 this.slaid_quatro = ( this.getSlaid_default());
			 
			break;
		case 1:
			 this.slaid_um     = ( !(b.obterProdutos().get(0)).equals("")?  b.obterProdutos().get(0): this.getSlaid_default());
			 this.slaid_dois   = (  this.getSlaid_default());
			 this.slaid_tres   = (  this.getSlaid_default());
			 this.slaid_quatro = (  this.getSlaid_default());
			 
			break;
		case 0:
			 this.slaid_um     = (  this.getSlaid_default());
			 this.slaid_dois   = (  this.getSlaid_default());
			 this.slaid_tres   = (  this.getSlaid_default());
			 this.slaid_quatro = (  this.getSlaid_default());
			 
			break;	
		default:
			break;
			
			//video 2
			
		}
			
		// init promocao	
			 int size = pr.obterProdutos().size();
			 System.err.println(size + " *********************************************");
		switch (size) {
			case 0:
				 this.promocao1 =    this.getPromocao_default()  ;
				  this.promocao2 =  this.getPromocao_default()  ;
				  this.promocao3 =  this.getPromocao_default()  ;
				  this.promocao4 =  this.getPromocao_default()  ;
				  this.promocao5 =  this.getPromocao_default()  ;
				  this.promocao6 =  this.getPromocao_default()  ;
				  this.promocao7 =  this.getPromocao_default()  ;
				break;
			case 1: //cria 6
				this.promocao1 = (!(pr.obterProdutos().get(0) == null) ? pr.obterProdutos().get(0) : this.getPromocao_default()  );
				  this.promocao2 =  this.getPromocao_default()  ;
				  this.promocao3 =  this.getPromocao_default()  ;
				  this.promocao4 =  this.getPromocao_default()  ;
				  this.promocao5 =  this.getPromocao_default()  ;
				  this.promocao6 =  this.getPromocao_default()  ;
				  this.promocao7 =  this.getPromocao_default()  ;
				break;
			case 2: //cria 5
				 this.promocao1 = (!(pr.obterProdutos().get(0) == null) ? pr.obterProdutos().get(0) : this.getPromocao_default()  );
				  this.promocao2 = (!(pr.obterProdutos().get(1) == null) ? pr.obterProdutos().get(1) : this.getPromocao_default()  );
				  this.promocao3 =   this.getPromocao_default()  ;
				  this.promocao4 =  this.getPromocao_default()  ;
				  this.promocao5 =  this.getPromocao_default()  ;
				  this.promocao6 =  this.getPromocao_default()  ;
				  this.promocao7 =  this.getPromocao_default()  ;
						break;
			case 3: //cria 4
				 this.promocao1 = (!(pr.obterProdutos().get(0) == null) ? pr.obterProdutos().get(0) : this.getPromocao_default()  );
				  this.promocao2 = (!(pr.obterProdutos().get(1) == null) ? pr.obterProdutos().get(1) : this.getPromocao_default()  );
				  this.promocao3 = (!(pr.obterProdutos().get(2) == null) ? pr.obterProdutos().get(2) : this.getPromocao_default()  );
				  this.promocao4 =  this.getPromocao_default()  ;
				  this.promocao5 =  this.getPromocao_default()  ;
				  this.promocao6 =  this.getPromocao_default()  ;
				  this.promocao7 =  this.getPromocao_default()  ;
				break;
			case 4: //cria 3
				  this.promocao1 = (!(pr.obterProdutos().get(0) == null) ? pr.obterProdutos().get(0) : this.getPromocao_default()  );
				  this.promocao2 = (!(pr.obterProdutos().get(1) == null) ? pr.obterProdutos().get(1) : this.getPromocao_default()  );
				  this.promocao3 = (!(pr.obterProdutos().get(2) == null) ? pr.obterProdutos().get(2) : this.getPromocao_default()  );
				  this.promocao4 = (!(pr.obterProdutos().get(3) == null) ? pr.obterProdutos().get(3) : this.getPromocao_default()  );
				  this.promocao5 =  this.getPromocao_default()  ;
				  this.promocao6 =  this.getPromocao_default()  ;
				  this.promocao7 =  this.getPromocao_default()  ;
				break;
			case 5: //cria 2
				  this.promocao1 = (!(pr.obterProdutos().get(0) == null) ? pr.obterProdutos().get(0) : this.getPromocao_default()  );
				  this.promocao2 = (!(pr.obterProdutos().get(1) == null) ? pr.obterProdutos().get(1) : this.getPromocao_default()  );
				  this.promocao3 = (!(pr.obterProdutos().get(2) == null) ? pr.obterProdutos().get(2) : this.getPromocao_default()  );
				  this.promocao4 = (!(pr.obterProdutos().get(3) == null) ? pr.obterProdutos().get(3) : this.getPromocao_default()  );
				  this.promocao5 = (!(pr.obterProdutos().get(4) == null) ? pr.obterProdutos().get(4) : this.getPromocao_default()  );
				  this.promocao6 =  this.getPromocao_default()  ;
				  this.promocao7 =  this.getPromocao_default()  ;
				
				break;
			case 6: //cria 1
				  this.promocao1 = (!(pr.obterProdutos().get(0) == null) ? pr.obterProdutos().get(0) : this.getPromocao_default()  );
				  this.promocao2 = (!(pr.obterProdutos().get(1) == null) ? pr.obterProdutos().get(1) : this.getPromocao_default()  );
				  this.promocao3 = (!(pr.obterProdutos().get(2) == null) ? pr.obterProdutos().get(2) : this.getPromocao_default()  );
				  this.promocao4 = (!(pr.obterProdutos().get(3) == null) ? pr.obterProdutos().get(3) : this.getPromocao_default()  );
				  this.promocao5 = (!(pr.obterProdutos().get(4) == null) ? pr.obterProdutos().get(4) : this.getPromocao_default()  );
				  this.promocao6 = (!(pr.obterProdutos().get(5) == null) ? pr.obterProdutos().get(5) : this.getPromocao_default()  );
				  this.promocao7 =  this.getPromocao_default()  ;
				
				break;	
			case 7:
				  this.promocao1 = (!(pr.obterProdutos().get(0) == null) ? pr.obterProdutos().get(0) : this.getPromocao_default()  );
				  this.promocao2 = (!(pr.obterProdutos().get(1) == null) ? pr.obterProdutos().get(1) : this.getPromocao_default()  );
				  this.promocao3 = (!(pr.obterProdutos().get(2) == null) ? pr.obterProdutos().get(2) : this.getPromocao_default()  );
				  this.promocao4 = (!(pr.obterProdutos().get(3) == null) ? pr.obterProdutos().get(3) : this.getPromocao_default()  );
				  this.promocao5 = (!(pr.obterProdutos().get(4) == null) ? pr.obterProdutos().get(4) : this.getPromocao_default()  );
				  this.promocao6 = (!(pr.obterProdutos().get(5) == null) ? pr.obterProdutos().get(5) : this.getPromocao_default()  );
				  this.promocao7 = (!(pr.obterProdutos().get(6) == null) ? pr.obterProdutos().get(6) : this.getPromocao_default()  );
				break;
		}	 
		
	   int sizeV = v.obterVideo().size();
		  switch (sizeV) {
		case 0:
			this.video1 = this.getVideoa_default();
			this.video2 = this.getVideoa_default();
			break;
		case 1:
			 this.video1 = (!(v.obterVideo().get(0) == null) ? v.obterVideo().get(0) : this.getVideoa_default()  );
			this.video2 = this.getVideoa_default();
			break;
		case 2:
			 this.video1 = (!(v.obterVideo().get(0) == null) ? v.obterVideo().get(0) : this.getVideoa_default()  );
			 this.video2 = (!(v.obterVideo().get(1) == null) ? v.obterVideo().get(1) : this.getVideoa_default()  );
			break;
		default:
			break;
		}
		  
	}
	   
	   
	 //******************************************************************
		//SLAIDS 4 SOMENTE 4
	   
	   //slaid default auxilia casso nao haja o numero de slaid para que supre a necessidade
	 
	   public Banner getSlaid_default() {
		   
		   String img_default = "resources/imagem_site/slaid_default.png";
		   String nome = "Produto Default";
		   String desc = "Descrição default";
		   Banner bdf = new Banner();
		   Produto p = new Produto();
		   
		   p.setDesc(desc);
		   p.setEstoque(1);
		   p.setImg1(img_default);
		   p.setImg2(img_default);
		   p.setImg3(img_default);
		   p.setNome(nome);
		   p.setValor((float) 00);
		   bdf.setImgBannerPrin(img_default);
		   bdf.setProduto(produto);
		   
			return slaid_default;
		}
	 //******************************************************************
	//PROMOCAO 7 SOMENTE 7
	   
	   //promocao default auxilia casso nao haja o numero de promocoes  supre a necessidade
	 public Produto getPromocao_default(){
		 String img_default = "resources/imagem_site/slaid_default.png";
		   String nome = "Produto Default";
		   String desc = "Descrição default";
		   Produto pd = new Produto();
		   
		   pd.setDesc(desc);
		   pd.setEstoque(1);
		   pd.setImg1(img_default);
		   pd.setImg2(img_default);
		   pd.setImg3(img_default);
		   pd.setNome(nome);
		   pd.setValor((float) 99.99);
		   
			return pd;
	 }
	 //******************************************************************
		//VIDEO 2 SOMENTE 2
	 public Video getVideoa_default(){
		 String url_default = "iLFq9wbdFQw";
		   Video v = new Video();
		   v.setUrl(url_default);
			return v;
	 }
	 
	 //CARRINHO
	 //***************************************************************************
	 public void carrinho(Object o ){
		 System.err.println("########################### ADD OBJETO ########################### "+ o.toString());
		 this.listCarrinho.add(o);
	 }
	 @SuppressWarnings("unchecked")
	public List<Produto> getCarrinhoProduto(){
		
		 return  ((List<Produto>) (Object) listCarrinho);
	 }

	 
	 //lista de produtos por tipo 
	 // 1 - adesivo 2 - curso 3 - jogo 4 - diver
	 public List<Produto> listProdutosAdesivo(){
		  ProdutoDAO pD = new ProdutoDAO();
		  return pD.getProdutoByTipo(1);
	 }
	 public List<Produto> listProdutosCurso(){
		  ProdutoDAO pD = new ProdutoDAO();
		  return pD.getProdutoByTipo(2);
	 }
	 public List<Produto> listProdutosJogo(){
		  ProdutoDAO pD = new ProdutoDAO();
		  return pD.getProdutoByTipo(3);
	 }
	 public List<Produto> listProdutosDiverso(){
		  ProdutoDAO pD = new ProdutoDAO();
		  return pD.getProdutoByTipo(4);
	 }
	 
	 //finalizando pedido
	 public String finalizando(List<Produto> p){
		 this.listProdutDoCarrinho = p;
		 return "carrinho.xhtml ";
	 }
	 //soma total do carrinho
	 public float total(){
		 float total =0;
		 for( int i = 0 ; i < this.listProdutDoCarrinho.size(); i++){
			 total += listProdutDoCarrinho.get(i).getValor();
		 }
		 return total;
	 }
	 //finalizar pagamento
	 public String finalizarPagamento(){
		 return "login.xhtml";
	 }
	 
//gett set
	 
	 
	 public Banner getSlaid_um() {
		return slaid_um;
	}

	

	public List<Produto> getListProdutDoCarrinho() {
		return listProdutDoCarrinho;
	}


	public void setListProdutDoCarrinho(List<Produto> listProdutDoCarrinho) {
		this.listProdutDoCarrinho = listProdutDoCarrinho;
	}


	public Produto getPromocao1() {
		return promocao1;
	}


	public void setPromocao1(Produto promocao1) {
		this.promocao1 = promocao1;
	}


	public Produto getPromocao2() {
		return promocao2;
	}


	public void setPromocao2(Produto promocao2) {
		this.promocao2 = promocao2;
	}


	public Produto getPromocao3() {
		return promocao3;
	}


	public void setPromocao3(Produto promocao3) {
		this.promocao3 = promocao3;
	}


	public Produto getPromocao4() {
		return promocao4;
	}


	public void setPromocao4(Produto promocao4) {
		this.promocao4 = promocao4;
	}


	public Produto getPromocao5() {
		return promocao5;
	}


	public void setPromocao5(Produto promocao5) {
		this.promocao5 = promocao5;
	}


	public Produto getPromocao6() {
		return promocao6;
	}


	public void setPromocao6(Produto promocao6) {
		this.promocao6 = promocao6;
	}


	public Produto getPromocao7() {
		return promocao7;
	}


	public void setPromocao7(Produto promocao7) {
		this.promocao7 = promocao7;
	}


	public void setSlaid_um(Banner slaid_um) {
		this.slaid_um = slaid_um;
	}

	public Banner getSlaid_dois() {
		return slaid_dois;
	}

	public void setSlaid_dois(Banner slaid_dois) {
		this.slaid_dois = slaid_dois;
	}

	public Banner getSlaid_tres() {
		return slaid_tres;
	}

	public void setSlaid_tres(Banner slaid_tres) {
		this.slaid_tres = slaid_tres;
	}

	public Banner getSlaid_quatro() {
		return slaid_quatro;
	}

	public void setSlaid_quatro(Banner slaid_quatro) {
		this.slaid_quatro = slaid_quatro;
	}


	public Video getVideo1() {
		return video1;
	}


	public void setVideo1(Video video1) {
		this.video1 = video1;
	}
	public Video getVideo2() {
		return video2;
	}


	public void setVideo2(Video video1) {
		this.video2 = video1;
	}


	public List<Object> getListCarrinho() {
		return listCarrinho;
	}


	public void setListCarrinho(List<Object> listCarrinho) {
		this.listCarrinho = listCarrinho;
	}
	
	//******************************************************************




	

}
