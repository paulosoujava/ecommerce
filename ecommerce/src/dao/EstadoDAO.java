package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Cidade;
import entity.Estado;

public class EstadoDAO {
	

	private Connection conexao;

	public EstadoDAO() {
		this.getConexao();
	}

	private void getConexao() {
		this.conexao = new ConnectionFactory().obterConexao();
	}
	
public int incluir( Estado e ) {
		
		
		//verificar se ja nao esta incluso
		if( e != null ){
		
			this.getConexao();
			int idInserido = 0;
			String sql = "INSERT INTO estado (nome  ) VALUES (?)";
			try {
				PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				// seta os valores
				stmt.setString(1, e.getSigla());
				
				// executa
				stmt.executeUpdate();
	
				ResultSet rs = stmt.getGeneratedKeys();
	
				if (rs.next()) {
					idInserido = rs.getInt(1);
				}
	
				if (idInserido > 0) {
					System.out.println("Estado inserida com sucesso");
				} else {
					System.out.println("Erro ao inserir estado");
				}
	
				stmt.close();
	
				return idInserido;
				
			} catch (SQLException ec) {
				System.out.println("Erro ao inserir estado: " + ec.getMessage());
				throw new RuntimeException(ec);
			} finally {
				ConnectionFactory.fecharConexao(this.conexao);
			}
		}else{
			return 0;
		}
	}


public int atualizar(Estado en ) {
	this.getConexao();
	int idInserido = 0;

	
	String sql = "UPDATE estado SET nome=? WHERE idestado=? ";

			
	try {
		PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		// seta os valores
		// seta os valores
		stmt.setString(1, en.getSigla());
		
		// executa
		stmt.executeUpdate();

		ResultSet rs = stmt.getGeneratedKeys();

		if (rs.next()) {
			idInserido = rs.getInt(1);
		}

		if (idInserido > 0) {
			System.out.println("Estado atualizado com sucesso");
		} else {
			System.out.println("Erro ao atualizar estado");
		}

		stmt.close();

		return idInserido;
		
	} catch (SQLException e) {
		System.out.println("Erro ao atualizar estado: " + e.getMessage());
		throw new RuntimeException(e);
	} finally {
		ConnectionFactory.fecharConexao(this.conexao);
	}
}

}
