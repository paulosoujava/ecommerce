package bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import dao.LoginDAO;
import entity.Pessoa;

@ManagedBean(name = "ctrlLogin")
@RequestScoped
public class Login implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6493704355085121657L;
	private Pessoa p = new Pessoa();
	private String msg = "";
	
	public String logar(){
		
		Pessoa newPessoa = new Pessoa();
		if( this.p != null ){
			
		LoginDAO lD = new LoginDAO();
		newPessoa = lD.isLogin(this.p.getEmail(), this.p.getSenha() ) ;
		
		if( newPessoa != null ){
			
			this.setP(newPessoa);
		    return "admin/admin.xhtml?faces-redirect=true";
		
			
		}else{
			this.msg = "OPSS, não encontrei, a senha/email estão corretos?";
	       return null;
		}
		}else{
			return null;
		}
	}
	
	public String sair(){
		return "../index.xhtml";
	}
	public String naoLogado(){
		return "/index.xhtml?faces-redirect=true";
	}
	

	
	public Pessoa getP() {
		return p;
	}

	public void setP(Pessoa p) {
		this.p = p;
	}



	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}

	
	
	
	
}
