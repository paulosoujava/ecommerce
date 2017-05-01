package bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.BannerDAO;
import dao.VideoDAO;
import entity.Produto;
import entity.Video;

@ManagedBean(name = "ctrlCadVid")
@RequestScoped
public class cadVideo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3822384789685849837L;
    private Video video = new Video();
    private VideoDAO vDao = new VideoDAO();
    private String msg = "";
    
	public String inclur(){
		
		if( this.video != null ){
			if( vDao.incluir(this.video) > 0 ){
				video = new Video();
				this.msg = "Ebaa, video incluido com sucesso.";
			}else{
				this.msg = "Opss, erro nosso, tente mais tarde.";
			}
		}else{
			this.msg = "Opss, dados em branco não são aceitos.";
		}
		return null;
	}
    
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
    
	public int qtdVideo(){
		VideoDAO p = new VideoDAO();
		return p.obterVideo().size();
	}
}
