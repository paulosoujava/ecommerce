package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Cidade;
import entity.Endereco;
import entity.Estado;
import entity.Pessoa;

public class LoginDAO {
	
	private Connection conexao;

	public LoginDAO() {
		this.getConexao();
	}
	
	private void getConexao() {
		this.conexao = new ConnectionFactory().obterConexao();
	}
	
	public Pessoa isLogin( String email, String senha ){
		this.getConexao();
		
		String sql = "SELECT * FROM Pessoa WHERE email = ? AND senha = ? AND nivel = 1 ";
	
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setMaxRows(1);
			stmt.setString(1, email);
			stmt.setString(2, senha);
			// executa
			ResultSet rs = stmt.executeQuery();
			Pessoa p = new Pessoa();
			
			while (rs.next()) {
				 
				p.setId(Integer.parseInt( rs.getString("idpessoa")));
				p.setNome(rs.getString("nome"));
				p.setSobreNome(rs.getString("sobrenome"));
				
			}
			
			stmt.close();
			return p;

		} catch (SQLException e) {
			System.out.println("Erro ao obter o login: " + e.getMessage());
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.fecharConexao(this.conexao);
		}
	
	
	
  }
	
	public Pessoa isClienteLogar( String email, String senha ){
		this.getConexao();
		
		String sql = " SELECT  * FROM pessoa  WHERE email = ? AND senha = ? AND nivel = 0   ";
	
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setMaxRows(1);
			stmt.setString(1, email);
			stmt.setString(2, senha);
			// executa
			ResultSet rs = stmt.executeQuery();
			Pessoa p = new Pessoa();
		
			 
			 
			while (rs.next()) {
				p.setId(Integer.parseInt( rs.getString("idpessoa")));
				p.setNome(rs.getString("nome"));
				p.setSobreNome(rs.getString("sobrenome"));
				p.setCpf(rs.getString("cpf"));
				p.setEmail(rs.getString("email"));
				p.setFone(rs.getString("fone"));
				
				
			}
			
			stmt.close();
			return p;

		} catch (SQLException e) {
			System.out.println("Erro ao obter o cliente: " + e.getMessage());
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.fecharConexao(this.conexao);
		}
	
	
	
  }

	
	public Pessoa isCliente( String email, String senha ){
		this.getConexao();
		
		String sql = " SELECT p.idpessoa, p.nome, p.sobrenome, p.cpf, p.email,p.fone, "+ 
							" e.nome, e.bairro, e.cep,  e.comp, e.ref, e.numero, e.idendereco,"+ 
							"    c.nome, es.nome"+ 
							"    FROM pessoa p"+ 
							" INNER JOIN endereco e ON p.idpessoa = e.idpessoa"+ 
							" INNER JOIN cidade c ON c.idcidade = e.idcidade "+ 
							" INNER JOIN estado es ON es.idestado = c.idestado"+ 
							" WHERE email = ? AND senha = ? AND nivel = 0   ";
	
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setMaxRows(1);
			stmt.setString(1, email);
			stmt.setString(2, senha);
			// executa
			ResultSet rs = stmt.executeQuery();
			Pessoa p = new Pessoa();
			Cidade c = new Cidade();
			Estado es = new Estado();
			Endereco e = new Endereco();
			 
			 
			while (rs.next()) {
				p.setId(Integer.parseInt( rs.getString("p.idpessoa")));
				p.setNome(rs.getString("p.nome"));
				p.setSobreNome(rs.getString("p.sobrenome"));
				p.setCpf(rs.getString("p.cpf"));
				p.setEmail(rs.getString("p.email"));
				p.setFone(rs.getString("p.fone"));
				
				//endereco
				e.setBairro(rs.getString("e.bairro"));
				e.setCep( Integer.parseInt(rs.getString("e.cep") ));
				e.setComp(rs.getString("e.comp"));
				e.setMumero( Integer.parseInt( rs.getString("e.numero")));
				e.setNome(rs.getString("e.nome"));
				e.setRef(rs.getString("e.ref"));

				c.setCidade(rs.getString("c.nome"));
				es.setSigla(rs.getString("es.nome"));
				c.setEstado(es);
				e.setCidade(c);
				p.setEndereco(e);
				
			}
			
			stmt.close();
			return p;

		} catch (SQLException e) {
			System.out.println("Erro ao obter o cliente: " + e.getMessage());
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.fecharConexao(this.conexao);
		}
	
	
	
  }
	
}
