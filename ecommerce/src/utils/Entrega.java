package utils;

import java.util.List;

import entity.Pessoa;
import entity.Produto;

public class Entrega {
	
	private Pessoa pessoa;
	private List<Produto> list;
	private String txt_adicional;
	private String resp_pela_coleta;
	private String telefone_adicional;
	
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public List<Produto> getList() {
		return list;
	}
	public void setList(List<Produto> list) {
		this.list = list;
	}
	public String getTxt_adicional() {
		return txt_adicional;
	}
	public void setTxt_adicional(String txt_adicional) {
		this.txt_adicional = txt_adicional;
	}
	public String getResp_pela_coleta() {
		return resp_pela_coleta;
	}
	public void setResp_pela_coleta(String resp_pela_coleta) {
		this.resp_pela_coleta = resp_pela_coleta;
	}
	public String getTelefone_adicional() {
		return telefone_adicional;
	}
	public void setTelefone_adicional(String telefone_adicional) {
		this.telefone_adicional = telefone_adicional;
	}
	
	

}
