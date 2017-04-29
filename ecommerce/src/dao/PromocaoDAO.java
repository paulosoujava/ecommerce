package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Produto;

public class PromocaoDAO {

	private Connection conexao;

	public PromocaoDAO() {
		this.getConexao();
	}
	
	private void getConexao() {
		this.conexao = new ConnectionFactory().obterConexao();
	}
	
	public Produto getProdutoById(Integer id){
		

		this.getConexao();
		
		String sql = "SELECT * FROM promocao WHERE idpromocao = ? ";
		

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setMaxRows(1);
			stmt.setInt(1, id);
			// executa
			ResultSet rs = stmt.executeQuery();
			Produto p = new Produto();
			
			while (rs.next()) {
				
				p.setDesc(rs.getString("descricao"));
				p.setIdProduto(Integer.parseInt( rs.getString("idpromocao")));
				p.setNome(rs.getString("nome"));
				p.setEstoque(Integer.parseInt( rs.getString("estoque")));
				p.setValor(Float.parseFloat(rs.getString("valor")));
				p.setImg1(rs.getString("url1"));
				p.setImg2(rs.getString("url2"));
				p.setImg3(rs.getString("url3"));
				
			}

			stmt.close();
			return p;

		} catch (SQLException e) {
			System.out.println("Erro ao obter promocao: " + e.getMessage());
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.fecharConexao(this.conexao);
		}
	
	
	
}

	public int incluir(Produto p ) {
		this.getConexao();
		int idInserido = 0;
		String sql = "INSERT INTO `ecommerce`.`promocao` (nome, descricao, url1, url2, url3,  valor, estoque) VALUES (?, ?, ?, ?, ?, ?,?)";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// seta os valores
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getDesc());
			stmt.setString(3, p.getImg1());
			stmt.setString(4, p.getImg2());
			stmt.setString(5, p.getImg3());
			stmt.setFloat(6, p.getValor());
			stmt.setInt(7, p.getEstoque());
			
			
			
			// executa
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				idInserido = rs.getInt(1);
			}

			if (idInserido > 0) {
				System.out.println("Promocao inserido com sucesso");
			} else {
				System.out.println("Erro ao inserir promocao");
			}

			stmt.close();

			return idInserido;
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir promocao: " + e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.fecharConexao(this.conexao);
		}
	}
	public List<Produto> obterProdutos() {
		this.getConexao();
		Produto p = null;
      List<Produto> pl = new ArrayList<>();
		String sql = "SELECT * FROM promocao ";
	try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			
			// executa
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				p = new Produto();
				p.setDesc(rs.getString("descricao"));
				p.setIdProduto(Integer.parseInt( rs.getString("idpromocao")));
				p.setNome(rs.getString("nome"));
				p.setEstoque(Integer.parseInt( rs.getString("estoque")));
				p.setValor(Float.parseFloat(rs.getString("valor")));
				p.setImg1(rs.getString("url1"));
				p.setImg2(rs.getString("url2"));
				p.setImg3(rs.getString("url3"));
				
				pl.add(p);
			}

			stmt.close();
			return pl;

		} catch (SQLException e) {
			System.out.println("Erro ao obter promocao: " + e.getMessage());
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.fecharConexao(this.conexao);
		}
	}

	public boolean removerProduto(Produto produto) {
		this.getConexao();

		boolean removidoSucesso = false;
		String sql = "DELETE FROM promocao WHERE idpromocao = ?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, produto.getIdProduto());
			int ok = stmt.executeUpdate();

			if (ok == 1) {
				System.out.println("Promocao removida com sucesso");
				removidoSucesso = true;
			} else {
				System.out.println("Erro ao remover promocao");
			}

			stmt.close();
			return removidoSucesso;
		} catch (SQLException e) {
			System.out.println("Erro ao remover promocao: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}
	public int atualizar(Produto p ) {
		this.getConexao();
		int idInserido = 0;
		String sql = "UPDATE promocao SET nome=?, descricao=?, estoque=?, valor=?,  url1=?, url2=?, url3=? WHERE idpromocao=? ";

				
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// seta os valores
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getDesc());
			stmt.setInt(3, p.getEstoque());
			stmt.setFloat(4, p.getValor());
			stmt.setString(5, p.getImg1());
			stmt.setString(6, p.getImg2());
			stmt.setString(7, p.getImg3());
			stmt.setInt(8, p.getIdProduto());
			
			// executa
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				idInserido = rs.getInt(1);
			}

			if (idInserido > 0) {
				System.out.println("Promocao atualizado com sucesso");
			} else {
				System.out.println("Erro ao atualizar promocao");
			}

			stmt.close();

			return idInserido;
			
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar promocao: " + e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.fecharConexao(this.conexao);
		}
	}

}
