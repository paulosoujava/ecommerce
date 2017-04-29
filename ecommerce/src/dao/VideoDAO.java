package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Banner;
import entity.Pessoa;
import entity.Video;

public class VideoDAO {
	private Connection conexao;

	public VideoDAO() {
		this.getConexao();
	}
	
	private void getConexao() {
		this.conexao = new ConnectionFactory().obterConexao();
	}
	
	public int incluir(Video v ) {
		this.getConexao();
		int idInserido = 0;
		String sql = "INSERT INTO `ecommerce`.`video` (url) VALUES (?)";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// seta os valores
			stmt.setString(1, v.getUrl());
			
			
			
			// executa
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				idInserido = rs.getInt(1);
			}

			if (idInserido > 0) {
				System.out.println("video inserido com sucesso");
			} else {
				System.out.println("Erro ao video banner");
			}

			stmt.close();

			return idInserido;
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir video: " + e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.fecharConexao(this.conexao);
		}
	}

	public List<Video> obterVideo() {
		this.getConexao();
		Video v = null;
		List<Video>list = new ArrayList<>();

		String sql = "SELECT * FROM video";
	try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
		
			// executa
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				v = new Video();
				v.setIdVideo( rs.getInt("idvideo"));
				v.setUrl(rs.getString("url"));
				list.add(v);
			}

			stmt.close();
			return list;

		} catch (SQLException e) {
			System.out.println("Erro ao obter videos: " + e.getMessage());
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.fecharConexao(this.conexao);
		}
	}
	public boolean removerVideo(Video v) {
		this.getConexao();

		boolean removidoSucesso = false;
		String sql = "DELETE FROM video WHERE idvideo = ?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, v.getIdVideo());
			int ok = stmt.executeUpdate();

			if (ok == 1) {
				System.out.println("video removido com sucesso");
				removidoSucesso = true;
			} else {
				System.out.println("Erro ao video banner");
			}

			stmt.close();
			return removidoSucesso;
		} catch (SQLException e) {
			System.out.println("Erro ao remover video: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}
	public int atualizar(Video v ) {
		this.getConexao();
		int idInserido = 0;
		String sql = "UPDATE video SET url=? WHERE idvideo=? ";

				
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// seta os valores
			stmt.setString(1, v.getUrl());
			stmt.setInt(2, v.getIdVideo());
			
			// executa
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				idInserido = rs.getInt(1);
			}

			if (idInserido > 0) {
				System.out.println("video atualizado com sucesso");
			} else {
				System.out.println("Erro ao atualizar video");
			}

			stmt.close();

			return idInserido;
			
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar video: " + e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.fecharConexao(this.conexao);
		}
	}

}
