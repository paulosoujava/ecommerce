package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Compra;
import entity.Pessoa;
import entity.Produto;

public class CompraDAO {

	private Connection conexao;

	public CompraDAO() {
		this.getConexao();
	}
	
	private void getConexao() {
		this.conexao = new ConnectionFactory().obterConexao();
	}
	
	public List<Compra> getCompra(){
		

		this.getConexao();
		
		String sql = "SELECT c.status, p.nome, p.sobrenome,p.cpf,p.fone,p.email,pr.nome,pr.descricao,pr.estoque,pr.valor " +
					 " FROM compra c INNER JOIN pessoa p on c.idpessoa = p.idpessoa"+ 
					 " INNER JOIN produto pr on pr.idproduto = c.idproduto;";
		
		List<Compra> cList = new ArrayList<>();
		

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			// executa
		  ResultSet rs = stmt.executeQuery();
	
		 
			
			while (rs.next()) {
				Pessoa pessoa = new Pessoa();
				   Produto produto = new Produto();
				//pessoa
				 pessoa.setCpf(rs.getString("p.cpf"));
				 pessoa.setEmail(rs.getString("p.email"));
				 pessoa.setFone(rs.getString("p.fone"));
				 pessoa.setNome(rs.getString("p.nome"));
				 pessoa.setSobreNome(rs.getString("p.sobrenome"));
				 System.out.println(pessoa);
				//produto 
				 produto.setDesc(rs.getString("pr.descricao"));
				 produto.setNome(rs.getString("pr.nome"));
				 produto.setEstoque(Integer.parseInt(rs.getString("pr.estoque")));
				 produto.setValor(Float.parseFloat( rs.getString("pr.valor" )));
				System.out.println(produto);
				
				 cList.add(new Compra(pessoa, produto, rs.getString("c.status")));
				
			}

			stmt.close();
			return cList;

		} catch (SQLException e) {
			System.out.println("Erro ao obter compra: " + e.getMessage());
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.fecharConexao(this.conexao);
		}
	
	
	
  }
	
public List<Compra> getCompraDiaAtual(){
		

		this.getConexao();
		
		String sql = " SELECT c.status, p.nome, p.sobrenome,p.cpf,p.fone,p.email,pr.nome,pr.descricao,pr.estoque,pr.valor"+
					  " FROM compra c INNER JOIN pessoa p on c.idpessoa = p.idpessoa " +
					  " INNER JOIN produto pr on pr.idproduto = c.idproduto WHERE  DATE_FORMAT(c.data, '%Y-%m-%d');";
		
		List<Compra> cList = new ArrayList<>();
		

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			// executa
		  ResultSet rs = stmt.executeQuery();
		   
		 
			
			while (rs.next()) {
				Pessoa pessoa = new Pessoa();
				   Produto produto = new Produto();
				//pessoa
				 pessoa.setCpf(rs.getString("p.cpf"));
				 pessoa.setEmail(rs.getString("p.email"));
				 pessoa.setFone(rs.getString("p.fone"));
				 pessoa.setNome(rs.getString("p.nome"));
				 pessoa.setSobreNome(rs.getString("p.sobrenome"));
				 System.out.println(" compra hj "+ pessoa);
				//produto 
				 produto.setDesc(rs.getString("pr.descricao"));
				 produto.setNome(rs.getString("pr.nome"));
				 produto.setEstoque(Integer.parseInt(rs.getString("pr.estoque")));
				 produto.setValor(Float.parseFloat( rs.getString("pr.valor" )));
				System.out.println(produto);
				
				 cList.add(new Compra(pessoa, produto, rs.getString("c.status")));
				
			}

			stmt.close();
			return cList;

		} catch (SQLException e) {
			System.out.println("Erro ao obter compra: " + e.getMessage());
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.fecharConexao(this.conexao);
		}
	
	
  }

}
