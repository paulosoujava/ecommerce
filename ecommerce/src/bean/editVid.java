package bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.PromocaoDAO;
import dao.VideoDAO;
import entity.Produto;
import entity.Video;

@ManagedBean(name = "ctrlLisVid")
@RequestScoped
public class editVid implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3971193493967079118L;
	/**
	 * 
	 */
	private VideoDAO pDAO = new VideoDAO();
	private Video produto = new Video();
	
	
	public List<Video> getListVideo() {
	
		return pDAO.obterVideo();
	}
	
	public String editar(Video v) {
		this.produto = v;
		System.out.println(produto);
		return "editVideo.xhtml";
	}
	public String atualizar( ){
		pDAO.atualizar(this.produto);
			return "listVideo.xhtml?faces-redirect=true";
		
	}
	public String deletar(){
		
		if(pDAO.removerVideo(this.produto)  ){
			return "listVideo.xhtml?faces-redirect=true";
		}else{
			return null;
		}
	}

	public Video getVideo() {
		return produto;
	}

	public void setVideo(Video produto) {
		this.produto = produto;
	}

}
