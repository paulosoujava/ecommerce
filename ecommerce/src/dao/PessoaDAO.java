package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Cidade;
import entity.Endereco;
import entity.Estado;
import entity.Pessoa;

public class PessoaDAO {

	private Connection conexao;

	public PessoaDAO() {
		this.getConexao();
	}

	private void getConexao() {
		this.conexao = new ConnectionFactory().obterConexao();
	}

	//cadastro da pessoa no banco retornando o id da pessoa cadastrada
	public int incluir(Pessoa pessoa) {
		this.getConexao();
		int idInserido = 0;
		String sql = "INSERT INTO Pessoa (nome, sobrenome,  cpf, fone, email, senha,  dataCadastro) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// seta os valores
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getSobreNome());
			stmt.setString(3, pessoa.getCpf());
			stmt.setString(4, pessoa.getFone());
			stmt.setString(5, pessoa.getEmail());
			stmt.setString(6, pessoa.getSenha());
			stmt.setDate(7, new java.sql.Date(java.util.Calendar.getInstance().getTimeInMillis()));
			
			
			// executa
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				idInserido = rs.getInt(1);
			}

			if (idInserido > 0) {
				System.out.println("Pessoa inserida com sucesso");
			} else {
				System.out.println("Erro ao inserir pessoa");
			}

			stmt.close();

			return idInserido;
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir pessoa: " + e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.fecharConexao(this.conexao);
		}
	}
		
	public boolean remover(int cdPessoa) {
		this.getConexao();

		boolean removidoSucesso = false;
		String sql = "DELETE FROM Pessoa WHERE id = ?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cdPessoa);
			int ok = stmt.executeUpdate();

			if (ok == 1) {
				System.out.println("Pessoa removida com sucesso");
				removidoSucesso = true;
			} else {
				System.out.println("Erro ao remover pessoa");
			}

			stmt.close();
			return removidoSucesso;
		} catch (SQLException e) {
			System.out.println("Erro ao remover Pessoa: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}

	public Pessoa obterPessoa(String email) {
		this.getConexao();
		Pessoa pessoa = null;

		String sql = "SELECT * FROM Pessoa WHERE email = ?";
	try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setMaxRows(1);
			stmt.setString(1, email);
			// executa
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				pessoa = new Pessoa();
				pessoa.setId(rs.getInt("id"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setSobreNome(rs.getString("sobrenome"));
				System.out.println("PESSOA: " + pessoa.getId() + " :: ");
			}

			stmt.close();
			return pessoa;

		} catch (SQLException e) {
			System.out.println("Erro ao obter pessoa: " + e.getMessage());
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.fecharConexao(this.conexao);
		}
	}

	public  List<Pessoa> listarPessoa() {
		this.getConexao();
		Pessoa pessoa =new Pessoa();
		List<Pessoa> lis = new ArrayList<>();
		String sql = "SELECT * FROM pessoa WHERE nivel != 1";
		try {

			PreparedStatement stmt = conexao.prepareStatement(sql);
			
		
			// executa
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				pessoa = new Pessoa();
				pessoa.setId(rs.getInt("idpessoa"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setSobreNome(rs.getString("sobrenome"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setFone(rs.getString("fone"));
				lis.add(pessoa);
				
			}

			stmt.close();
			return lis;
		} catch (SQLException e) {
			System.out.println("Erro ao listar pessoas: By Id " + e.getMessage());
			return null;
		} finally {
			ConnectionFactory.fecharConexao(this.conexao);
		}
	}
	public  Pessoa listarById(Integer id) {
		this.getConexao();
		Pessoa pessoa = null;
		Endereco endereco = null;
		Cidade cidade = null;
		Estado estado = null;
		
		String sql = " SELECT   p.nome, p.sobrenome, p.cpf, p.fone, p.email,  e.nome, e.numero,  e.bairro, e.cep, e.comp, e.ref, c.nome, es.nome "+
						"  FROM pessoa p INNER JOIN endereco e ON p.idpessoa = e.idpessoa  "+
						" INNER JOIN cidade c ON e.idcidade = c.idcidade INNER JOIN estado es ON "+ 
						" c.idestado = es.idestado  WHERE p.idpessoa = ? ";
		try {

			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setMaxRows(1);
			stmt.setInt(1, id);
		
			// executa
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				pessoa = new Pessoa();
				endereco = new Endereco();
				cidade = new Cidade();
				estado = new Estado();
				 
			
				pessoa.setNome(rs.getString("p.nome"));
				pessoa.setSobreNome(rs.getString("p.sobrenome"));
				pessoa.setEmail(rs.getString("p.email"));
				pessoa.setCpf(rs.getString("p.cpf"));
				pessoa.setFone(rs.getString("p.fone"));
				
				endereco.setBairro(rs.getString("e.bairro"));
				endereco.setCep(rs.getInt("e.cep"));
				
				cidade.setCidade(rs.getString("c.nome"));
				estado.setSigla(rs.getString("es.nome"));
				cidade.setEstado(estado);
				
				endereco.setCidade(cidade);
				
				endereco.setComp(rs.getString("e.comp"));
				endereco.setMumero(rs.getInt("e.numero"));
				endereco.setNome(rs.getString("e.nome"));
				endereco.setRef(rs.getString("e.ref"));
				
				pessoa.setEndereco(endereco);
				
				
			}

			stmt.close();
			return pessoa;
		} catch (SQLException e) {
			System.out.println("Erro ao listar pessoas: By Id " + e.getMessage());
			return pessoa;
		} finally {
			ConnectionFactory.fecharConexao(this.conexao);
		}
	}
	
	public boolean logado(String email){
		this.getConexao();
	String sql = "SELECT * FROM Pessoa WHERE email = ? AND logado = 1";
	try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setMaxRows(1);
			stmt.setString(1, email);
			// executa
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return true;
			}
			stmt.close();

		} catch (SQLException e) {
			System.out.println("Erro ao obter pessoa: " + e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			ConnectionFactory.fecharConexao(this.conexao);
		}
		return false;
	}
	
	}