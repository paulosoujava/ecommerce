package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.EnderecoDAO;
import entity.Cidade;
import entity.Endereco;
import entity.Estado;
import entity.Pessoa;

@ManagedBean(name = "ctrlEndereco")
@SessionScoped
public class cadEndereco {
	
	private Endereco endereco = new Endereco();
	private Cidade cidade = new Cidade();
	private Estado estado = new Estado();
	EnderecoDAO enderecoDao = new EnderecoDAO();
	private String msg = "";
	
	
	
	public String cadastrarEndereco( Pessoa p ){
		
		this.cidade = (p.getEndereco().getCidade());
		this.endereco = (p.getEndereco());
		this.estado = (p.getEndereco().getCidade().getEstado());
		
		//conferir
		if( enderecoDao.obterEnderecoDaPessoa(p.getId())){
			//atualiza
			enderecoDao.atualizar(this.endereco, p.getId(), this.cidade, this.estado);
		}else{
			enderecoDao.incluir(this.endereco, p.getId(), this.cidade, this.estado);
		}
		this.msg = "Opaa, tudo certo...";
		
		return null;
	}
	
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}

	
	
	

}
