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

public class EnderecoDAO {

	private Connection conexao;

	public EnderecoDAO() {
		this.getConexao();
	}

	private void getConexao() {
		this.conexao = new ConnectionFactory().obterConexao();
	}
	
	
	public int incluir(Endereco en, Integer idPessoa, Cidade c, Estado estado ) {
		
		
		//verificar se ja nao esta incluso
		if( en != null ){
		
			this.getConexao();
			int idInserido = 0;
			String sql = "INSERT INTO endereco (nome, bairro,  cep, comp, ref, idpessoa, idcidade,numero  ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				
				int idEstado = 0;
				int idCidade = 0;
				
				EstadoDAO estadoDAO = new EstadoDAO();
				CidadeDAO cidadeDAO = new CidadeDAO();
				
				idEstado = estadoDAO.incluir(estado);
				idCidade =  cidadeDAO.incluir(c, idEstado);
				
				PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				// seta os valores
				stmt.setString(1, en.getNome());
				stmt.setString(2, en.getBairro());
				stmt.setInt(3, en.getCep());
				stmt.setString(4, en.getComp());
				stmt.setString(5, en.getRef());
				stmt.setInt(6, idPessoa);
				stmt.setInt(7, idCidade);
				stmt.setInt(8, en.getMumero());
				
				
				
				// executa
				stmt.executeUpdate();
	
				ResultSet rs = stmt.getGeneratedKeys();
	
				if (rs.next()) {
					
					
					idInserido = rs.getInt(1);
				}
	
				if (idInserido > 0) {
					System.out.println("Endereco inserida com sucesso");
				} else {
					System.out.println("Erro ao inserir endereco");
				}
	
				stmt.close();
	
				return idInserido;
				
			} catch (SQLException ex) {
				System.out.println("Erro ao inserir endereco: " + ex.getMessage());
				throw new RuntimeException(ex);
			} finally {
				ConnectionFactory.fecharConexao(this.conexao);
			}
		}else{
			return 0;
		}
	}
	

	public int atualizar(Endereco en,Integer idPessoa, Cidade c, Estado estado  ) {
		this.getConexao();
		int idInserido = 0;

		
		String sql = "UPDATE endereco SET nome=?, bairro=?, cep=?, comp=?, ref=?, numero=? WHERE idpessoa=? ";

				
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// seta os valores
			// seta os valores
			stmt.setString(1, en.getNome());
			stmt.setString(2, en.getBairro());
			stmt.setInt(3, en.getCep());
			stmt.setString(4, en.getComp());
			stmt.setString(5, en.getRef());
			stmt.setInt(6, en.getMumero());
			stmt.setInt(7, idPessoa );
			
			// executa
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				
				EstadoDAO estadoDAO = new EstadoDAO();
				CidadeDAO cidadeDAO = new CidadeDAO();
				
				  estadoDAO.atualizar(estado);
			      cidadeDAO.atualizar(c);
				idInserido = rs.getInt(1);
				
			}

			if (idInserido > 0) {
				System.out.println("endereco atualizado com sucesso");
			} else {
				System.out.println("Erro ao atualizar endereco");
			}

			stmt.close();

			return idInserido;
			
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar pessoa: " + e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.fecharConexao(this.conexao);
		}
	}

	public boolean obterEnderecoDaPessoa(Integer id) {
		this.getConexao();

		String sql = "SELECT * FROM endereco WHERE idpessoa = ?";
	try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setMaxRows(1);
			stmt.setInt(1, id);
			// executa
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				stmt.close();
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao obter endereco: " + e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			ConnectionFactory.fecharConexao(this.conexao);
		}
	return false;
	}

		
}
