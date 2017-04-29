package bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.CompraDAO;
import dao.PessoaDAO;
import entity.Cidade;
import entity.Compra;
import entity.Endereco;
import entity.Estado;
import entity.Pessoa;


@ManagedBean(name = "ctrlLoj")
@SessionScoped
public class Loja implements Serializable {


	private CompraDAO cpDao = new CompraDAO();
	private PessoaDAO pDAO = new PessoaDAO();
	private Pessoa pessoa = new Pessoa();
	private Endereco endereco = new Endereco();
	private Cidade ciade = new Cidade();
	Estado estado = new Estado();
	private String msg = "";
	private static final long serialVersionUID = 763273420141072853L;
	
	
	public String perfil(int id ){
		Pessoa p = new Pessoa();
		p = (pDAO.listarById(id) ); 
		if( p != null ){
		this.pessoa.setCpf(p.getCpf());
		this.pessoa.setEmail(p.getEmail());
		this.pessoa.setFone(p.getFone());
		this.pessoa.setNome(p.getNome());
		this.pessoa.setSobreNome(p.getSobreNome());
		
		this.endereco.setBairro(p.getEndereco().getBairro());
		this.endereco.setCep(p.getEndereco().getCep());
		this.ciade.setCidade( p.getEndereco().getCidade().getCidade() );
		
		this.endereco.setCidade(ciade);
		this.estado.setSigla(p.getEndereco().getCidade().getEstado().getSigla());
		this.ciade.setEstado(estado);
		this.endereco.setComp(p.getEndereco().getComp());
		
		this.endereco.setMumero(p.getEndereco().getMumero());
		this.endereco.setNome(p.getEndereco().getNome());
		this.endereco.setRef(p.getEndereco().getRef());
		
		this.pessoa.setEndereco(endereco);
		
		
		return "cliente.xhtml";
		}else{
			this.msg = " Opss, está pessoa não cadastrou o endereço ainda.";
			return null;
		}
	}
	
	public List<Pessoa> getListPessoa() {

		return pDAO.listarPessoa();
	}
	
	public void setCpDao(CompraDAO cpDao) {
		this.cpDao = cpDao;
	}

	public List<Compra> getVendaHoje(){
		for(int i = 0 ; i < cpDao.getCompraDiaAtual().size(); i++ ){
			System.err.println(cpDao.getCompraDiaAtual().get(i).getPessoa().getEmail());
		}
		return cpDao.getCompraDiaAtual();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	

}
