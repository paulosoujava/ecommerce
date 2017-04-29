package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Pessoa;
import entity.Produto;

public class ProdutoDAO {
	private Connection conexao;

	public ProdutoDAO() {
		this.getConexao();
	}
	
	private void getConexao() {
		this.conexao = new ConnectionFactory().obterConexao();
	}
	
	public Produto getProdutoById(Integer id){
		

		this.getConexao();
		
		String sql = "SELECT * FROM produto WHERE idproduto = ? ";
		

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setMaxRows(1);
			stmt.setInt(1, id);
			// executa
			ResultSet rs = stmt.executeQuery();
			Produto p = new Produto();
			
			while (rs.next()) {
				
				p.setDesc(rs.getString(""));
				p.setIdProduto(Integer.parseInt( rs.getString("")));
				p.setNome(rs.getString(""));
				p.setEstoque(Integer.parseInt( rs.getString("")));
				p.setValor(Float.parseFloat(rs.getString("")));
				
			}

			stmt.close();
			return p;

		} catch (SQLException e) {
			System.out.println("Erro ao obter compra: " + e.getMessage());
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.fecharConexao(this.conexao);
		}
	
	
	
}

	public int incluir(Produto p ) {
		this.getConexao();
		int idInserido = 0;
		String sql = "INSERT INTO `ecommerce`.`produto` (`nome`, `descricao`, `estoque`, `valor`, `img1`, `img2`, `img3`) VALUES (?, ?, ?, ?, ?, ?,?)";
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
			
			// executa
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				idInserido = rs.getInt(1);
			}

			if (idInserido > 0) {
				System.out.println("Produto inserido com sucesso");
			} else {
				System.out.println("Erro ao inserir pproduto");
			}

			stmt.close();

			return idInserido;
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir produto: " + e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.fecharConexao(this.conexao);
		}
	}
	public List<Produto> obterProdutos() {
		this.getConexao();
		Produto p = null;
      List<Produto> pl = new ArrayList<>();
		String sql = "SELECT * FROM produto ";
	try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			
			// executa
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				p = new Produto();
				p.setIdProduto(rs.getInt("idproduto"));
				p.setNome(rs.getString("nome"));
				p.setDesc(rs.getString("descricao"));
				p.setEstoque(Integer.parseInt( rs.getString("estoque")));
				p.setValor(Float.parseFloat( rs.getString("valor")));
				p.setImg1(rs.getString("img1"));
				p.setImg2(rs.getString("img2"));
				p.setImg3(rs.getString("img3"));
				pl.add(p);
			}

			stmt.close();
			return pl;

		} catch (SQLException e) {
			System.out.println("Erro ao obter produto: " + e.getMessage());
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.fecharConexao(this.conexao);
		}
	}

	public boolean removerProduto(Produto produto) {
		this.getConexao();

		boolean removidoSucesso = false;
		String sql = "DELETE FROM produto WHERE idproduto = ?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, produto.getIdProduto());
			int ok = stmt.executeUpdate();

			if (ok == 1) {
				System.out.println("Produto removida com sucesso");
				removidoSucesso = true;
			} else {
				System.out.println("Erro ao remover produto");
			}

			stmt.close();
			return removidoSucesso;
		} catch (SQLException e) {
			System.out.println("Erro ao remover Produto: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}
	public int atualizar(Produto p ) {
		this.getConexao();
		int idInserido = 0;
		String sql = "UPDATE produto SET nome=?, descricao=?, estoque=?, valor=?,  img1=?, img2=?, img3=? WHERE idproduto=? ";

				
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
				System.out.println("Produto atualizado com sucesso");
			} else {
				System.out.println("Erro ao atualizar pproduto");
			}

			stmt.close();

			return idInserido;
			
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar produto: " + e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.fecharConexao(this.conexao);
		}
	}

}
