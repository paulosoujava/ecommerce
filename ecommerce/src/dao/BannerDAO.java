package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Banner;
import entity.Produto;

public class BannerDAO {

	private Connection conexao;

	public BannerDAO() {
		this.getConexao();
	}
	
	private void getConexao() {
		this.conexao = new ConnectionFactory().obterConexao();
	}
	
	public Banner getProdutoById(Integer id){
		

		this.getConexao();
		
		String sql = "SELECT * FROM banner WHERE idbanner = ? ";
		

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setMaxRows(1);
			stmt.setInt(1, id);
			// executa
			ResultSet rs = stmt.executeQuery();
			Produto p = new Produto();
			Banner b = new Banner();
			
			while (rs.next()) {
				
				p.setDesc(rs.getString("descricao"));
				p.setIdProduto(Integer.parseInt( rs.getString("idbanner")));
				p.setNome(rs.getString("nome"));
				p.setEstoque(Integer.parseInt( rs.getString("estoque")));
				p.setValor(Float.parseFloat(rs.getString("valor")));
				p.setImg1(rs.getString("url1"));
				p.setImg2(rs.getString("url2"));
				p.setImg3(rs.getString("url3"));
				b.setImgBannerPrin(rs.getString("imgprincipal"));
				b.setProduto(p);
				
			}

			stmt.close();
			return b;

		} catch (SQLException e) {
			System.out.println("Erro ao obter banner: " + e.getMessage());
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.fecharConexao(this.conexao);
		}
	
	
	
}

	public int incluir(Banner p ) {
		this.getConexao();
		int idInserido = 0;
		String sql = "INSERT INTO `ecommerce`.`banner` (nome, descricao, url1, url2, url3,  valor, estoque, imgprincipal) VALUES (?,?, ?, ?, ?, ?, ?,?)";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// seta os valores
			stmt.setString(1, p.getProduto().getNome());
			stmt.setString(2, p.getProduto().getDesc());
			stmt.setString(3, p.getProduto().getImg1());
			stmt.setString(4, p.getProduto().getImg2());
			stmt.setString(5, p.getProduto().getImg3());
			stmt.setFloat(6, p.getProduto().getValor());
			stmt.setInt(7, p.getProduto().getEstoque());
			stmt.setString(8, p.getImgBannerPrin());
			
			
			
			// executa
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				idInserido = rs.getInt(1);
			}

			if (idInserido > 0) {
				System.out.println("banner inserido com sucesso");
			} else {
				System.out.println("Erro ao inserir banner");
			}

			stmt.close();

			return idInserido;
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir banner: " + e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.fecharConexao(this.conexao);
		}
	}
	
	public List<Banner> obterProdutos() {
		this.getConexao();
		Produto p = null;
		Banner b = null;
      List<Banner> pl = new ArrayList<>();
		String sql = "SELECT * FROM banner ";
	try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			
			// executa
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				p = new Produto();
				b = new Banner();
				
				p.setDesc(rs.getString("descricao"));
				p.setNome(rs.getString("nome"));
				p.setDesc(rs.getString("descricao"));
				p.setEstoque(Integer.parseInt( rs.getString("estoque")));
				p.setValor(Float.parseFloat(rs.getString("valor")));
				p.setImg1(rs.getString("url1"));
				p.setImg2(rs.getString("url2"));
				p.setImg3(rs.getString("url3"));
				b.setProduto(p);
				b.setImgBannerPrin(rs.getString("imgprincipal"));
				b.setIdBanner( Integer.parseInt( rs.getString("idbanner"))); 
				pl.add(b);
			}

			stmt.close();
			return pl;

		} catch (SQLException e) {
			System.out.println("Erro ao obter banner: " + e.getMessage());
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.fecharConexao(this.conexao);
		}
	}

	public boolean removerProduto(Banner produto) {
		this.getConexao();

		boolean removidoSucesso = false;
		String sql = "DELETE FROM banner WHERE idbanner = ?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, produto.getIdBanner());
			int ok = stmt.executeUpdate();

			if (ok == 1) {
				System.out.println("banner removido com sucesso");
				removidoSucesso = true;
			} else {
				System.out.println("Erro ao remover banner");
			}

			stmt.close();
			return removidoSucesso;
		} catch (SQLException e) {
			System.out.println("Erro ao remover banner: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}
	public int atualizar(Banner p ) {
		this.getConexao();
		int idInserido = 0;
		String sql = "UPDATE banner SET nome=?, descricao=?, estoque=?, valor=?,  url1=?, url2=?, url3=?, imgprincipal = ? WHERE idbanner=? ";

				
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// seta os valores
			stmt.setString(1, p.getProduto().getNome());
			stmt.setString(2, p.getProduto().getDesc());
			stmt.setInt(3, p.getProduto().getEstoque());
			stmt.setFloat(4, p.getProduto().getValor());
			stmt.setString(5, p.getProduto().getImg1());
			stmt.setString(6, p.getProduto().getImg2());
			stmt.setString(7, p.getProduto().getImg3());
			stmt.setString(8, p.getImgBannerPrin());
			stmt.setInt(9, p.getIdBanner());
			
			// executa
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				idInserido = rs.getInt(1);
			}

			if (idInserido > 0) {
				System.out.println("banner atualizado com sucesso");
			} else {
				System.out.println("Erro ao atualizar banner");
			}

			stmt.close();

			return idInserido;
			
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar banner: " + e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.fecharConexao(this.conexao);
		}
	}

}
