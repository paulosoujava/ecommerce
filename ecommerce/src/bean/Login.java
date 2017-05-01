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

import dao.EnderecoDAO;
import dao.LoginDAO;
import dao.PessoaDAO;
import entity.Cidade;
import entity.Endereco;
import entity.Estado;
import entity.Pessoa;

@ManagedBean(name = "ctrlLogin")
@SessionScoped
public class Login implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6493704355085121657L;
	private Pessoa pessoa  = new Pessoa();
	private Pessoa cliente  = new Pessoa();
	
	private String msg = "";
	private String senha = "";
	private String msgLogin = "";
	
	
	//ADMIN
	public String logar(){
		
		Pessoa newPessoa = new Pessoa();
		if( this.pessoa != null ){
			
		LoginDAO lD = new LoginDAO();
		newPessoa = lD.isLogin(this.pessoa.getEmail(), this.pessoa.getSenha() ) ;
		
		if( newPessoa != null ){
			
			this.setPessoa(newPessoa);
		    return "admin/admin.xhtml?faces-redirect=true";
		
			
		}else{
			this.msg = "OPSS, não encontrei, a senha/email estão corretos?";
	       return null;
		}
		}else{
			return null;
		}
	}
	
	
	public String logarCliente(){
		Pessoa newPessoa = new Pessoa();
		if( this.pessoa.getEmail().isEmpty() || this.pessoa.getSenha().isEmpty() ){
			this.msgLogin = "OPSS, n a senha/email estão vazias?";
			return null;
		}else{
				LoginDAO lD = new LoginDAO();
				newPessoa = lD.isCliente(this.pessoa.getEmail(), this.pessoa.getSenha() ) ;
				System.out.println(newPessoa + " ***************************************** ");
				if( newPessoa.getNome() != null  ){
					this.setPessoa(newPessoa);
				    return "pagamento.xhtml";
				}else{
					this.msgLogin = "OPSS, não encontrei, a senha/email estão corretos?";
			       return null;
				}
		}
	}
	
	
	
	public String sair(){
		return "../index.xhtml";
	}
	public String naoLogado(){
		return "/index.xhtml?faces-redirect=true";
	}
	

	//cadastrar novo user
	public void cadastrar(Pessoa p){
		
		 PessoaDAO pD = new PessoaDAO();
		
		if( p == null){
			this.msg = "Opss, insira seus dados";
		}else{
			
		  if(	pD.obterPessoa(p.getEmail()) == null ){
			
		if( senha.equals(p.getSenha())){
		 
			if(p.getEmail().indexOf("@") != -1 && p.getEmail().indexOf(".") != -1){
				int idPessoainserido =   pD.incluir(p);
				if( idPessoainserido  > 0 ){
		
					//teste
					
					p = new Pessoa();
					this.msg = "Opa, cadastrado com sucesso, já pode usar sua senha e login para acessa;";
				}else{
					this.msg ="Opaa, erro nosso ";
				}
			}else{
				this.msg = "Opsss, digite um email válido.";
			}
		}else{
			this.msg = "Opsss, senhas não conferem.";
		}
		  }else{
				this.msg ="Opaa, já existe um usuário cadastrado com este email ";
			}
	 }
		
	}
	
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa p) {
		this.pessoa = p;
	}



	public Pessoa getCliente() {
		return cliente;
	}
	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}
	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getMsgLogin() {
		return msgLogin;
	}
	public void setMsgLogin(String msgLogin) {
		this.msgLogin = msgLogin;
	}

	
	
	
	
}
