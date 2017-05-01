package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;

import dao.EnderecoDAO;
import dao.PessoaDAO;
import entity.Cidade;
import entity.Endereco;
import entity.Estado;
import entity.Pessoa;
import entity.Produto;

@ManagedBean(name = "ctrlPedido")
@SessionScoped
public class pedido {

	private Pessoa pessoa;
	private PessoaDAO pessoaDAO = new PessoaDAO();

	private Integer quantidadeDeProduto;
	private Float novoValor;
	private List<Produto> listProd = new ArrayList<>();

	private String msg = "";
	
	
	
	//atualizar usuario
	public String atualizarCliente(Pessoa p){
		
		pessoaDAO.atualizar(p);
			this.msg = "Opaaa, Atualizado com sucesso";
	
		return null;
	}

	

	//GET SET
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public PessoaDAO getPessoaDAO() {
		return pessoaDAO;
	}
	public void setPessoaDAO(PessoaDAO pessoaDAO) {
		this.pessoaDAO = pessoaDAO;
	}
	public Integer getQuantidadeDeProduto() {
		return quantidadeDeProduto;
	}
	public void setQuantidadeDeProduto(Integer quantidadeDeProduto) {
		this.quantidadeDeProduto = quantidadeDeProduto;
	}
	public Float getNovoValor() {
		return novoValor;
	}
	public void setNovoValor(Float novoValor) {
		this.novoValor = novoValor;
	}
	public List<Produto> getListProd() {
		return listProd;
	}
	public void setListProd(List<Produto> listProd) {
		this.listProd = listProd;
	}


	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


	
	
	
	
}
