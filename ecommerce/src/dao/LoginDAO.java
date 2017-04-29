package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	

}
