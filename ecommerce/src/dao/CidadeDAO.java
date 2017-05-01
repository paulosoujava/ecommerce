package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Cidade;
import entity.Endereco;

public class CidadeDAO {

	
	private Connection conexao;

	public CidadeDAO() {
		this.getConexao();
	}

	private void getConexao() {
		this.conexao = new ConnectionFactory().obterConexao();
	}
	
public int incluir( Cidade c, Integer idestado ) {
		
		
		//verificar se ja nao esta incluso
		if( c != null ){
		
			this.getConexao();
			int idInserido = 0;
			String sql = "INSERT INTO cidade (nome, idestado  ) VALUES (?, ?)";
			try {
				PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				// seta os valores
				stmt.setString(1, c.getCidade());
				stmt.setInt(2, idestado);
				
				
				
				// executa
				stmt.executeUpdate();
	
				ResultSet rs = stmt.getGeneratedKeys();
	
				if (rs.next()) {
					idInserido = rs.getInt(1);
				}
	
				if (idInserido > 0) {
					System.out.println("Cidade inserida com sucesso");
				} else {
					System.out.println("Erro ao inserir cidade");
				}
	
				stmt.close();
	
				return idInserido;
				
			} catch (SQLException e) {
				System.out.println("Erro ao inserir cidade: " + e.getMessage());
				throw new RuntimeException(e);
			} finally {
				ConnectionFactory.fecharConexao(this.conexao);
			}
		}else{
			return 0;
		}
	}


public int atualizar(Cidade en ) {
	this.getConexao();
	int idInserido = 0;

	
	String sql = "UPDATE cidade SET nome=? WHERE idcidade=? ";

			
	try {
		PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		// seta os valores
		// seta os valores
		stmt.setString(1, en.getCidade());
		
		// executa
		stmt.executeUpdate();

		ResultSet rs = stmt.getGeneratedKeys();

		if (rs.next()) {
			idInserido = rs.getInt(1);
		}

		if (idInserido > 0) {
			System.out.println("Cidade atualizado com sucesso");
		} else {
			System.out.println("Erro ao atualizar cidade");
		}

		stmt.close();

		return idInserido;
		
	} catch (SQLException e) {
		System.out.println("Erro ao atualizar cidade: " + e.getMessage());
		throw new RuntimeException(e);
	} finally {
		ConnectionFactory.fecharConexao(this.conexao);
	}
}



}
